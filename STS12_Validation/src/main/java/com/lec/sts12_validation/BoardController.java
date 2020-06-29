package com.lec.sts12_validation;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.beans.WriteDTO;

@Controller
@RequestMapping("/board")
public class BoardController {

	// handelr 생성
	@RequestMapping("write.do")
	public String write() {
		return "board/write";
	}
	
	@RequestMapping("writeOk.do")// submit 할때 처리하는 handler
	public String writeOk(@ModelAttribute("w") WriteDTO dto,
			BindingResult result) { // validator 가 유효성 검사를 한 결과가 담긴 객체
		System.out.println("writeOk():" + dto.getUid() + ":" + dto.getName());
		System.out.println("에러개수 :" + result.getErrorCount() + "개");
		String page = "board/writeOk";
		return page;
	}
	
	
}
