package kr.kh.spring;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
													// get 방식에서는 래퍼 클래스로 받아오는게 좋음 null이 가능하기 때문에
	public ModelAndView home(ModelAndView mv,String name,Integer age) {
		mv.addObject("name1", name); // name1은 화면에서 불릴이름
		mv.addObject("age1", age);
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(value = "/board/{num}")
	public ModelAndView board(ModelAndView mv, @PathVariable("num") Integer num) {
	System.out.println("게시글 번호 : " + num);
	mv.setViewName("home");
	return mv;
	}
	
	@RequestMapping(value = "/test")
	public ModelAndView board(ModelAndView mv,infoVO info) {
	mv.addObject("info1", info);
	mv.setViewName("home2");
	return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView mv) {
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(ModelAndView mv,String id,String pw) {
		mv.addObject("id", id);
		mv.addObject("pw", pw);
		mv.setViewName("login");
		return mv;
	}

}