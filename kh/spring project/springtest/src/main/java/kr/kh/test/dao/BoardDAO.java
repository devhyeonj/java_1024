package kr.kh.test.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.test.vo.BoardTypeVO;

public interface BoardDAO {
	
	ArrayList<BoardTypeVO> selectAllBoardType(@Param("authority")int adminAuthority);
	
	BoardTypeVO selectOne(@Param("bt_name") String bt_name);
	
	int insertBoard(@Param("bt") BoardTypeVO boardTypeVO);
	
	int updateBoard(@Param("bt") BoardTypeVO boardTypeVO);

}
