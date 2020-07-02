package com.lec.sts16_interceptor.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
	
	// 예제 : 테스트용 계정
	public static final String ADMIN_ID = "admin";
	public static final String ADMIN_PW = "1234";

	@RequestMapping("/login")
	public String logIn() {
		return "user/login";
	}
	
	// 로그인 ok handler
	@RequestMapping(value="/loginOk", method=RequestMethod.POST)
												// 마지막에 세션 매개변수로 받기 명시
	public String longinOk(String id, String pw, HttpSession session) {
		String returnURL = "";
		
		if(session.getAttribute("id") != null) {
			// 기존에 id 세션값이 존재한다면 (즉, 로그인 세션 정보가 있는 상태라면)
			session.removeAttribute("id");// 이전 로그인 세션 정보 삭제 
		}
		
		// 실제 회원 DB 테이블 쿼리 해야 하는 부분 
		if(ADMIN_ID.equals(id) && ADMIN_PW.equals(pw)) {
			// 로그인 성공
			session.setAttribute("id", id);
			
			// 원래 가고자 했던 url 이 있었다면 (session에 저장되어 있다)
			String priorUrl = (String)session.getAttribute("url_prior_login");
			if(priorUrl != null) {
				returnURL = "redirect:" + priorUrl;
				session.removeAttribute("url_prior_login");
			} else {
				// 원래 가고자 했떤 url 이 없었다면!
				returnURL = "redirect:/board/list.do";
			}
				
		} else {
			// 로그인 실패 - logfail에 history.back() 
			returnURL = "user/logfail";
		}
		
		return returnURL;
	} // end loginOk()
	
	
	// 로그아웃 
	@RequestMapping("/logout")
	public String logOut(HttpSession session) {
		session.removeAttribute("id");
		return "user/logout";
	}
	
	
	
	
	
	
	
}
