package kr.kh.test.service;

import java.util.ArrayList;

import kr.kh.test.vo.CommentVO;
import kr.kh.test.vo.MemberVO;

public interface CommentService {

	boolean insertComment(CommentVO comment, MemberVO user);

	ArrayList<CommentVO> getCommentList(int co_bo_num);

	int getTotalCountCommentList(int co_bo_num);

}
