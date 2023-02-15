package kr.kh.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.spring.vo.MemberVO;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView loginPost(ModelAndView mv,MemberVO member) {
		mv.setViewName("/board/list");
		return mv;
	}
	
	

}
