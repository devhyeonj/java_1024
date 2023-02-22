package kr.kh.test.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.test.service.AdminService;
import kr.kh.test.vo.BoardTypeVO;

@Controller
public class AdminController {
	
	@Autowired
	AdminService boardService;
	
	@RequestMapping(value = "/admin/board/type/list")
	public ModelAndView boardTypeList(ModelAndView mv) {
		ArrayList<BoardTypeVO> list = boardService.getBoardType();
		mv.addObject("list",list);
		mv.setViewName("/admin/boardTypeList");
		return mv;
	}

}
