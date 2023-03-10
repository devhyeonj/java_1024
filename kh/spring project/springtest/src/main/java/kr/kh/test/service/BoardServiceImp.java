package kr.kh.test.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.test.dao.BoardDAO;
import kr.kh.test.pagination.Criteria;
import kr.kh.test.util.UploadFileUtils;
import kr.kh.test.vo.BoardTypeVO;
import kr.kh.test.vo.BoardVO;
import kr.kh.test.vo.FileVO;
import kr.kh.test.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService {
	
	@Autowired
	BoardDAO boardDao;
	
	String uploadPath = "C:\\uploadfiles";
	
	@Override
	public ArrayList<BoardTypeVO> getBoardType(MemberVO user) {
		if(user == null || user.getMe_authority() == 0)
			return null;
		ArrayList<BoardTypeVO> bt = boardDao.selectAllBoardType(user.getMe_authority());
		return bt;
	}

	@Override
	public boolean insertBoard(BoardVO board, MemberVO user, MultipartFile[] files) {
		if(user == null || user.getMe_authority() == 0)
			return false;
		if(board == null || 
			board.getBo_title().trim().length() == 0 ||
			board.getBo_content().trim().length() == 0 ||
			board.getBo_bt_num() == 0)
			return false;
		
		board.setBo_me_id(user.getMe_id());
		
		int isOk = boardDao.insertBoard(board);
		if(isOk == 0)
			return false;

		insertFile(files,board);
	
		return true;
	}

	private void insertFile(MultipartFile[] files, BoardVO board) {
		for (MultipartFile f : files) {
			if(f == null || f.getOriginalFilename().length() ==0 )
				continue; // 등록안한 파일 등록안되게 if문으로 함
			// 업로드한 경로를 변수에 저장 
			String path;
			try {
				path = UploadFileUtils.uploadFile(uploadPath, f.getOriginalFilename(), f.getBytes());
				FileVO file = new FileVO(f.getOriginalFilename(), path, board.getBo_num());
				boardDao.insertFile(file);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}

	@Override
	public ArrayList<BoardVO> boardList(Criteria criteria) {
		ArrayList<BoardVO> list = boardDao.selectAllBoard(criteria);
		return list;
	}

	@Override
	public int getBoardToalCount(Criteria criteria) {
		criteria = criteria == null? new Criteria() : criteria;
		return boardDao.selectBoardTotalCount(criteria);
	}

	@Override
	public BoardVO getBoardAndUpdateView(int bo_num) {
		int res;
		res = boardDao.updateViews(bo_num);
		if(res == 0) // 증가가 안됨 (게시글이 없음)
			return null;
		return boardDao.selectBoard(bo_num);
	}

	@Override
	public ArrayList<FileVO> getFileList(int bo_num) {
		return boardDao.selectFile(bo_num);
	}

	@Override
	public boolean deleteBoard(Integer bo_num, MemberVO user) {
		if(user == null)
			return false;
		BoardVO board = boardDao.selectBoard(bo_num);
		ArrayList<FileVO> flieList = boardDao.selectFile(bo_num);
		deleteFileList(flieList);
		if(board == null)
			return false;
		if(!(board.getBo_me_id().equals(user.getMe_id())))
			return false; 
		return boardDao.deleteBoard(bo_num) != 0;
	}
	
	private void deleteFileList(ArrayList<FileVO> fileList) {
		if(fileList == null || fileList.size() == 0) 
			return;
		for(FileVO file : fileList) {
			UploadFileUtils.removeFile(uploadPath, file.getFi_name());
			boardDao.deleteFile(file.getFi_num());
		}
	}

	@Override
	public BoardVO getBoard(int bo_num) {
		return boardDao.selectBoard(bo_num);
	}
	


}
