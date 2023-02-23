package kr.kh.test.service;

import java.util.ArrayList;

import kr.kh.test.vo.BoardTypeVO;

public interface AdminService {
	
	ArrayList<BoardTypeVO> getBoardType();
	
	BoardTypeVO getBoard(String bt_name);
	
	boolean setBoard(BoardTypeVO boardTypeVO);
	
	boolean updateBoard(BoardTypeVO boardTypeVO);
	
	

}
