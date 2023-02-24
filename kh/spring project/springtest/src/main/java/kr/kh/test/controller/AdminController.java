package kr.kh.test.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.test.controller.utils.MessageUtils;
import kr.kh.test.service.AdminService;
import kr.kh.test.vo.BoardTypeVO;
import kr.kh.test.vo.MemberVO;

@Controller
public class AdminController {
	
	@Autowired
	AdminService boardService;
	
	@RequestMapping(value = "/admin/board/type/list", method = RequestMethod.GET)
	public ModelAndView boardTypeList(ModelAndView mv) {
		ArrayList<BoardTypeVO> list = boardService.getBoardType();
		mv.addObject("list",list);
		mv.setViewName("/admin/boardTypeList");
		return mv;
	}
	
	@RequestMapping(value = "/admin/board/type/insert", method = RequestMethod.POST)
	public ModelAndView adminBoardTypeInsert(ModelAndView mv,BoardTypeVO board,HttpServletResponse response,HttpServletRequest request) {
		//서비스에게 게시판 정보를 주면서 등록하라고 요청한 후 등록 여부를 알려줌
		boolean isInsert = boardService.setBoardType(board);
		if(isInsert) {
			MessageUtils.alertAndMovePage(response, "게시판 등록에 성공하였습니다.", request.getContextPath(), "/admin/board/type/list");
		}else {
			//화면에 게시판 등록 실패 메세지 전송
			MessageUtils.alertAndMovePage(response, "게시판 등록에 실패하였습니다.", request.getContextPath(), "/admin/board/type/list");
		}
		
		mv.setViewName("redirect:/admin/board/type/list");
		return mv;
	}
	@RequestMapping(value = "/admin/board/type/update", method = RequestMethod.POST)
	public ModelAndView adminBoardTypeUpdate(ModelAndView mv, BoardTypeVO boardTypeVO, HttpServletRequest request, HttpServletResponse response) {
		boolean isUpdate = boardService.updateBoardType(boardTypeVO);
		if(isUpdate) {
			MessageUtils.alertAndMovePage(response, "게시판 수정에 성공하였습니다.", request.getContextPath(), "/admin/board/type/list");
		}else {
			//화면에 게시판 등록 실패 메세지 전송
			MessageUtils.alertAndMovePage(response, "게시판 수정에 실패하였습니다.", request.getContextPath(), "/admin/board/type/list");
		}
		mv.setViewName("/admin/board/type/list");
		return mv;
	}
	@RequestMapping(value = "/admin/board/type/delete/{bt_num}", method = RequestMethod.GET)
	public ModelAndView adminBoardTypeDelete(ModelAndView mv,@PathVariable("bt_num") Integer bt_num,HttpServletRequest request,HttpServletResponse response) {
		boolean res = boardService.deleteBoardType(bt_num);
		if(res) {
			MessageUtils.alertAndMovePage(response, "게시판을 삭제했습니다.", request.getContextPath(), "/admin/board/type/list");
		}else {
			MessageUtils.alertAndMovePage(response, "이미 삭제된 게시판이거나 없는 게시판 입니다..", request.getContextPath(), "/admin/board/type/list");
		}
		mv.setViewName("redirect:/admin/board/type/list");
		return mv;
	}

}
