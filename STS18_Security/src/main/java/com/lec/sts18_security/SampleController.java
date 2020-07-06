package com.lec.sts18_security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample/*")
public class SampleController {
	
// return type 이 void!!!??? handler 에 return 타입 없으면
// url 과 같은 경로의 jsp 파일을 찾는다. --> ex. /all.jsp
	
//	@RequestMapping("/all")
//	@RequestMapping(value = "/all", method=RequestMethod.GET)의 축약형 
	@GetMapping("/all")
	public void doAll() {
		System.out.println("doAll() : accss everybody");
	}
	@GetMapping("/member")
	public void doMember() {
		System.out.println("doMember() : access member only");
	}
	@GetMapping("/admin")
	public void doAdmin() {
		System.out.println("doAdmin() : access admin only");
	}
	
}


