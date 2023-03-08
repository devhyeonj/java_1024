package kr.kh.test.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.test.service.BoardService;
import kr.kh.test.vo.BoardTypeVO;
import kr.kh.test.vo.BoardVO;
import kr.kh.test.vo.MemberVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/board/insert" , method = RequestMethod.GET)
	public ModelAndView boardInsert(ModelAndView mv,HttpSession session) {
		mv.setViewName("/board/insert");
		//로그인한 회원 정보를 가져옴
				MemberVO user = (MemberVO) session.getAttribute("user");
				// 가져온 회원 정보를 서비스에게 주면서 권한에 맞는 게시판 타입을 가져오라고 요청
				ArrayList<BoardTypeVO> bt= boardService.getBoardType(user);
				//가져온 게시판 타입 리스트를 화면에 전달
				mv.addObject("typeList",bt);
		return mv;
	}
	
	@RequestMapping(value="/board/insert", method=RequestMethod.POST)
	public ModelAndView boardInsertPost(ModelAndView mv, 
			HttpSession session, BoardVO board, MultipartFile[] files) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		String msg;
		if(boardService.insertBoard(board,user,files)) {
			msg = "게시글 등록 성공!";
		}else {
			msg = "게시글 등록 실패!";
		}
		mv.addObject("msg",msg);
		mv.addObject("url","/board/list");
		mv.setViewName("/common/message");
		return mv;
	}

}
