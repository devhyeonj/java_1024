package kr.kh.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.test.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// 컨트롤러가 ModelAndView에 담아서 보낸 user 정보를 가져오는 정보
		ModelMap modelMap = modelAndView.getModelMap();
		MemberVO user = (MemberVO) modelMap.get("user");
		//회원 정보가 있으면
		if(user != null) {
				//세션에 회원 정보를 추가
				//modelMap이 필요없음
				//user로 어디서든지 세션정보를 불러와서 쓸수있다
				//home.jsp ${user}는 세션 정보가 불러온거임
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
		}
		
	}

}
