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
		ArrayList<BoardTypeVO> boardType = boardDAO.selectAllBoardType();
		if(boardType == null)
			return null;
		return boardType;
	}

}
