package com.lec.sts11_param;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lec.beans.WriteDTO;

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
	
	// parameter 추출
	// handler 메소드에서도 서블릿에서 보앗던 HttpServletRequest, HttpServletResponse 매개변수 가능.!!!
	
	@RequestMapping(value = "/member/delete" , method = RequestMethod.GET)   // -> /member/delete?id=34
	public String delMember(Model model , HttpServletRequest request) { // 순서 바뀌어도 동작(handler / request)
		String id = request.getParameter("id");
		model.addAttribute("mbId", id);
		return "member/delete";
	}
	
	@RequestMapping(value = "/member/regOk", method = RequestMethod.POST)
	public String regOkMember() {
		System.out.println("member/regOk : POST");
		return "member/regOk";
	}

	@RequestMapping(value = "/member/regOk", method = RequestMethod.GET)
	public String regOkMember(Model model) {
		System.out.println("member/regOk : GET");
		return "member/regOk";
	}
	
	@RequestMapping(value = "/member/regist")
	public String registMember() {
		return "member/regist";
	}
	
	
	// GET/POST 둘다 받는 handler
	@RequestMapping(value = "/member/regOk2",
			method= {RequestMethod.GET, RequestMethod.POST})
	public String regOkMember2() {
		return "member/regOk";
	}
	
	// handler 에 
	// request parameter 의 name 값과 " 같은 이름의 매개변수" 가 있으면
	// 바로 그 매개벼수가 request parameter 값을 받아온다. (다른 무언가를 지정하지 않아도!)
	
//	@RequestMapping("/member/find")
//	public String findMember(int [] id, String [] name, Model model) {
//		model.addAttribute("id", Arrays.toString(id));
//		model.addAttribute("name",Arrays.toString(name));
//		============================================================
//		public String findMember(int id, String name, Model model) {
//		model.addAttribute("id", id);
//		model.addAttribute("name",name);
		
		
		//@RequestParam 사용
		@RequestMapping("member/find")
		public String findMember(Model model,
				@RequestParam("id") String userid, // name이 "id" parameter 값은 받아온다. 
				@RequestParam("name") String username) { // name 이라는 param 값이 오면 username 으로 받겠다
			
			model.addAttribute("id", userid);
			model.addAttribute("name", username);
		
		
		return "member/find";
	}
		
	
	//=========================================================
	// command 객체 사용 (command Object) == DTO 객체 
		
	@RequestMapping("/board/write")
	public String writeBoard() {
		return "board/write";
	}
		
	// 기존방식 으로 form 을 받아오는 것 구현하기 
	// 매 parameter 마다 매개변수화 해야한다. 번거롭다! 
	@RequestMapping(value = "/board/writeOk", method = RequestMethod.POST)
//	public String wrtieOkBoard(
//		Model model,
//		@RequestParam("name") String name,
//		@RequestParam("subject") String subject,
//		@RequestParam("content") String content
//		) {
//			WriteDTO dto = new WriteDTO();
//			dto.setName(name);
//			dto.setSubject(subject);
//			dto.setContent(content);
//			
//			model.addAttribute("dto", dto);
//			
//			return "board/writeOk";
//		}


	// command 사용 하는 방식 / 매게변수로 writedto type 으로 받기 (writedto.java 에서 getter setter 의 이름이 매칭)

	// 커맨드 객체 사용
	//	public String wrtieOkBoard(WriteDTO dto) {
		
	// 커맨드 객체에 attribute id 변경
	public String wrtieOkBoard(
			@ModelAttribute("DTO") WriteDTO dto) {
			
		System.out.println(dto);
		return "board/writeOk";
	}
	
	// @PathVariable 방식 : request parameter	를  GET 방식의 query string이 아닌
	// URL 경로에 담아 전달하는 방식
	@RequestMapping("/board/writePath/{name}/{subject}/{content}")
	public String writePathBoard(Model model,
			@PathVariable String name,
			@PathVariable String subject,
			@PathVariable String content
			) { 
		model.addAttribute("name", name);
		model.addAttribute("subject", subject);
		model.addAttribute("content", content);
		return "board/writePath";
	}
	
	@RequestMapping("/member/ageCheck")
	public String chkAge(int age,
			RedirectAttributes redirectAttr) {
		redirectAttr.addAttribute("age", age); // name ("age")지정해서 넘겨준다.
		if(age < 19) {
			return "redirect:/member/underAge"; // 조건에 맞으면 새로 request
		} else {
			return "redirect:/member/adult";
		}
	}
	
	// 각각에 대해 동작하는 handler
	@RequestMapping("/member/underAge")
	public String pageUnderAge(
			@RequestParam("age") int age, Model model
			) {
		// model 에 담기 -> view 까지 가게 된다. 
		model.addAttribute("age", age);
		return "member/ageUnder";
	}
	
	@RequestMapping("/member/adult")
	public String pageAdult(
			@RequestParam("age") int age, Model model
			) {
		return "member/ageAdult";
	}
	
	// 경로 확인용 
	@RequestMapping(value = "/common") // 만약에 common 으로 요청이 들어온다면 
	public String cccmmm() {			// cccmmm() 핸들러가 수행되고 ,
		return "comn";  // --> /WEB-INF/views/comn.jsp 를 리턴하여 response 되게 한다. 
		
	}
	
	}
		
		
