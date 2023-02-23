package kr.kh.test.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.test.dao.BoardDAO;
import kr.kh.test.vo.BoardTypeVO;

@Service
public class AdminServiceImp implements AdminService {
	
	@Autowired
	BoardDAO boardDAO;

	@Override
	public ArrayList<BoardTypeVO> getBoardType() {
		final int adminAuthority = 9; // 관리자 권한
		return boardDAO.selectAllBoardType(adminAuthority);
	}

	@Override
	public BoardTypeVO getBoard(String bt_name) {
		if(bt_name == null)
			return null;
		BoardTypeVO board = boardDAO.selectOne(bt_name);
		if(board == null)
			return null;
		return board;
	}

	@Override
	public boolean setBoard(BoardTypeVO board) {
				if(!checkBoardType(board))
					return false;
				
				int res = boardDAO.insertBoard(board);
				return res != 0;
				// return boardDao.insertBoardType(bt) != 0;
				
				
		}

	@Override
	public boolean updateBoard(BoardTypeVO board) {	
		if(!checkBoardType(board))
			return false;
		if(board.getBt_num() < 1)
			return false;
		BoardTypeVO dbBoard = getBoard(board.getBt_name());
		if(dbBoard != null)
			return false;
		return boardDAO.updateBoard(board) != 0;
	}
	//BoardTypeVO 체크(bt_num제외)
	private boolean checkBoardType(BoardTypeVO bt) {
		if(bt == null)
			return false;
		
		if(!(bt.getBt_type().equals("일반") || bt.getBt_type().equals("이미지"))) {
				return false;
			}
			if(!(bt.getBt_r_authority() == 0 || bt.getBt_r_authority() == 1 ||  bt.getBt_r_authority() == 9)) {
				return false;
			}
				if(!(bt.getBt_w_authority() == 1 || bt.getBt_w_authority() == 9)) {
					return false;
				}
				if(bt.getBt_name() == null || bt.getBt_name().trim().length() == 0)
					return false;
				//게시판명 중복 체크
				//다오에게 게시판명을 주면서 게시판정보를 가져오라고 시킴
				BoardTypeVO boardTypeVO = getBoard(bt.getBt_name());
				//가져온 게시판이 있는 경우
				// 1. 서로 다른 게시판인데 이름이 중복되는 경우(중복이므로 false)
				// 2. 같은 게시판인 경우(자기자신이므로  true)
				if(boardTypeVO != null && bt.getBt_num() != boardTypeVO.getBt_num())
					 return false;
				return true;
		
	}
}
	

