package com.lec.sts10_request;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/common") // 만약에 common 으로 요청이 들어온다면 
	public String cccmmm() {			// cccmmm() 핸들러가 수행되고 ,
		return "comn";  // --> /WEB-INF/views/comn.jsp 를 리턴하여 response 되게 한다. 
		
	}
	
	@RequestMapping(value = "/member/search")
	public String searchMember() {
		return "member/search";
	}
	
	@RequestMapping(value = "/member/infoView")
	public String infoMember(Model model) { // 매게변수 model 넘어옴
		// model에 데이터를 담아서 view 에 전달 
		model.addAttribute("mbAge", 30);
		model.addAttribute("mbName", "홍길동");
		return "member/info"; // info.jsp 필요하게됨.
	}
	
	@RequestMapping(value = "/member/find")
	public ModelAndView findMember() {
		ModelAndView mv = new ModelAndView();
		
		//데이터 담고
		mv.addObject("mbName", "다스베이터");
		mv.addObject("mbDate", "2020/06/22");
		
		//뷰지정
		mv.setViewName("member/find");
		
		return mv;
	}
	
	// 확장자 패턴 사용 가능
	@RequestMapping(value = "/member/*.do")
	public String domember() {
		return "member/domember";
	}
	
}
