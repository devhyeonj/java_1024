package kr.kh.test.dao;

import java.util.ArrayList;

import kr.kh.test.vo.BoardTypeVO;

public interface BoardDAO {
	
	ArrayList<BoardTypeVO> selectAllBoardType();

}
