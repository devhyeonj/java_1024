package kr.kh.spring.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.spring.service.BoardService;
import kr.kh.spring.utils.MessageUtils;
import kr.kh.spring.vo.BoardTypeVO;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.FileVO;
import kr.kh.spring.vo.MemberVO;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/board/list", method=RequestMethod.GET)
	public ModelAndView boardList(ModelAndView mv) {
		mv.setViewName("/board/list");
		//우선 전체 게시글을 가져오는 코드로 작성하고
		//추후에 페이지네이션 및 검색 기능을 적용
		ArrayList<BoardVO> list = boardService.getBoardList();
		mv.addObject("list", list);
		return mv;
	}
	@RequestMapping(value = "/board/insert", method=RequestMethod.GET)
	public ModelAndView boardInsert(ModelAndView mv,HttpServletRequest request) {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		ArrayList<BoardTypeVO> btList = boardService.getBoardType(user.getMe_authority());
		mv.addObject("btList", btList);
		//작성할 타입이 없으면 작성 페이지로 갈 필요가 없어서 게시글 리스트로 이동시킴
		if(btList.size() == 0) {
			mv.setViewName("redirect:/board/list");
		}else
			mv.setViewName("/board/insert");
		
		return mv;
	}
	@RequestMapping(value = "/board/insert", method=RequestMethod.POST)
	public ModelAndView boardInsertPost(ModelAndView mv,BoardVO board, 
			HttpSession session, MultipartFile[] files) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		boardService.insertBoard(board, user,files);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
	@RequestMapping(value = "/board/detail/{bo_num}", method=RequestMethod.GET)
	public ModelAndView boardDetail(ModelAndView mv,@PathVariable("bo_num")int bo_num,HttpSession session,HttpServletResponse response) {
		MemberVO user = (MemberVO) session.getAttribute("user");
		// 게시글을 가져올때 회원정보도 같이 넘겨줌
		BoardVO board = boardService.getBoard(bo_num,user);
		ArrayList<FileVO> files = boardService.getFileList(bo_num);
		mv.addObject("board", board);
		mv.addObject("files", files);
		if(board == null) {
			mv.setViewName("redirect:/board/list");
			MessageUtils.alertAndMovePage(response,
					"삭제되거나 조회권한이 없는 게시글 입니다."
					, "/spring", "/board/list");
		}else 
		mv.setViewName("/board/detail");
		
		return mv;
	}
	
	
}