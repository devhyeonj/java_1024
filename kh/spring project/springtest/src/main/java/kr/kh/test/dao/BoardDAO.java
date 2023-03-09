package kr.kh.test.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.test.pagination.Criteria;
import kr.kh.test.vo.BoardTypeVO;
import kr.kh.test.vo.BoardVO;
import kr.kh.test.vo.FileVO;

public interface BoardDAO {
	
	ArrayList<BoardTypeVO> selectAllBoardType(@Param("authority")int adminAuthority);
	
	BoardTypeVO selectOne(@Param("bt_name") String bt_name);
	
	int insertBoardType(@Param("bt") BoardTypeVO boardTypeVO);
	
	int updateBoardType(@Param("bt") BoardTypeVO boardTypeVO);
	
	boolean deleteBoardType(@Param("bt_num") Integer bt_num);

	int insertBoard(@Param("bo")BoardVO board);

	void insertFile(@Param("f") FileVO file);

	ArrayList<BoardVO> selectAllBoard(@Param("cri") Criteria criteria);

	int selectBoardTotalCount(@Param("cri") Criteria criteria);

	BoardVO selectBoard(@Param("bo_num") int bo_num);

	int updateViews(@Param("bo_num") int bo_num);

	ArrayList<FileVO> selectFile(@Param("bo_num") int bo_num);

}
