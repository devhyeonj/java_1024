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
		
		ModelMap modelMap = modelAndView.getModelMap();
		MemberVO user = (MemberVO) modelMap.get("user");
		
		if(user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
		}
		
		super.postHandle(request, response, handler, modelAndView);
	}

}
