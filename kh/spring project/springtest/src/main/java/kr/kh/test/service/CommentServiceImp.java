package kr.kh.test.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.test.dao.CommentDAO;
import kr.kh.test.vo.CommentVO;
import kr.kh.test.vo.MemberVO;

@Service
public class CommentServiceImp implements CommentService {

	@Autowired
	CommentDAO commentDao;

	@Override
	public boolean insertComment(CommentVO comment, MemberVO user) {
		if(comment == null || comment.getCo_content() == null ||  
				comment.getCo_content().trim().length() == 0)
			return false;
		if(user == null || user.getMe_id() == null)
			return false;
		comment.setCo_me_id(user.getMe_id());
		return commentDao.insertComment(comment) != 0;
	}

	@Override
	public ArrayList<CommentVO> getCommentList(int co_bo_num) {
		return null;
	}

	@Override
	public int getTotalCountCommentList(int co_bo_num) {
		return 0;
	}
}