package com.lec.sts18_security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommonController {
	@GetMapping("/accessError")
	// handler 에 Authentication 을 담아서 .... 
	// void 를 리턴 하기 때문에 url(/accessError)과 같은 jsp 파일을 리턴!!
	public void accessDenied(Authentication auth, Model model) {
		System.out.println("access Denied : " + auth);
		model.addAttribute("msg", "접근 권한 거부");
	}
	
	@GetMapping("/customLogin") // 로그인이 실패했을 때 로그인 페이지로 다시 돌아오면서 생기는 메세지들을 error 와 logout 이 담는다. 
	public void loginInput(String error, String logout, Model model) {
		System.out.println("error: " + error);
		System.out.println("logout: " + logout);

		if(error != null) {
			model.addAttribute("error", "Login Error Check Your Account");
		}
		if(logout != null) {
			model.addAttribute("logout", "Logout!!");
		}
	}
	
	@GetMapping("/customLogout")
	public void logoutGET() {
		System.out.println("custom logout");
	}
	
	@PostMapping("/cutomLogout")
	public void logoutPOST() {
		System.out.println("post custom logout");
	}
}
