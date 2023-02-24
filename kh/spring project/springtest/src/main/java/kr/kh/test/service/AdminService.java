package kr.kh.test.service;

import java.util.ArrayList;

import kr.kh.test.vo.BoardTypeVO;

public interface AdminService {
	
	ArrayList<BoardTypeVO> getBoardType();
	
	BoardTypeVO getBoardType(String bt_name);
	
	boolean setBoardType(BoardTypeVO boardTypeVO);
	
	boolean updateBoardType(BoardTypeVO boardTypeVO);
	
	boolean deleteBoardType(Integer bt_num);
	
	

}
