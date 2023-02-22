package kr.kh.test.controller;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.test.controller.utils.MessageUtils;
import kr.kh.test.service.MemberService;
import kr.kh.test.vo.MemberOKVO;
import kr.kh.test.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	String contextPath = "/test";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv, Integer num) {
		String name = memberService.selectMemberName(num);
		mv.setViewName("/main/home");
		return mv;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signup(ModelAndView mv) {
		mv.setViewName("/member/signup");
		return mv;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv,MemberVO member,HttpServletResponse response) {
		System.out.println(member); // 확인
	
		boolean isSignup = memberService.signup(member);
		if(isSignup) {
			 MessageUtils.alertAndMovePage(response, "회원가입에 성공했습니다.", contextPath, "/");
			mv.setViewName("redirect:/");
		}else {
			 MessageUtils.alertAndMovePage(response, "회원가입에 실패했습니다.", contextPath, "/signup");
			mv.setViewName("redirect:/signup");
		}
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView mv) {
		mv.setViewName("/member/login");
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(ModelAndView mv,MemberVO member,HttpServletResponse response) {
		 MemberVO user = memberService.login(member);
		 // 그외의 다른정보들을 세션에 저장해놓았다가 로그인 할때마다 꺼내쓰기 위해서 객체를 씀
		 //인증한 회원들만 로그인 하도록 
		 if(user != null && user.getMe_authority() > 0) {
			 mv.addObject("user", user);
			 mv.setViewName("redirect:/");
			 MessageUtils.alertAndMovePage(response, "로그인에 성공했습니다.", contextPath, "/");
		 }
		 else {
			 if(user != null) {
				 //인증 안된 회원이라고 알려주는 메세지
				 MessageUtils.alertAndMovePage(response, "이메일 인증을 완료해야 로그인이 로그인이 가능합니다.", contextPath, "/login");
			 }else {
				 MessageUtils.alertAndMovePage(response, "로그인에 실패했습니다.", contextPath, "/login");
			 }
			 mv.setViewName("redirect:/login"); //url입력하는거임 /member/login x
		 }
		return mv;
	}
	@RequestMapping(value = "/logout")
	public ModelAndView logout(ModelAndView mv,HttpSession session,HttpServletResponse response) {
		MemberVO member	= (MemberVO) session.getAttribute("user");
		if(member != null) {
			session.removeAttribute("user");
			 MessageUtils.alertAndMovePage(response, "로그아웃에 성공했습니다.", contextPath, "/");
		}
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@RequestMapping(value = "/email/authentication", method = RequestMethod.GET) 
	public ModelAndView emailAuthentication(ModelAndView mv,MemberOKVO mok,HttpServletResponse response) {
		boolean res = memberService.emailAuthentication(mok);
		if(res) {
			//인증 성공 메세지
			 MessageUtils.alertAndMovePage(response, "이메일 인증에 성공했습니다.", contextPath, "/");
		}else {
			//인증 실패 메세지
			 MessageUtils.alertAndMovePage(response, "이메일 인증에 실패했습니다.", contextPath, "/");
		}
		mv.setViewName("redirect:/");
		return mv;
	}
}
