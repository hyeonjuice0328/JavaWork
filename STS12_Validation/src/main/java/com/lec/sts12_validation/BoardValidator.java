package com.lec.sts12_validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.lec.beans.WriteDTO;

public class BoardValidator implements Validator {

	
	// 이 Validator 가 제공하는 class 의 인스턴스(clazz)를
	// 유효성 검사 할수 있는가? (true or false)
	@Override
	public boolean supports(Class<?> clazz) {
		//검증할 객체의 클래스 타입인지 확인 : WirteDTO = clazz; 가능여부
		return WriteDTO.class.isAssignableFrom(clazz);
	}

	// 주어신 객체 (target) 에 대한 유효성 검사를 하고 
	// 유효성 검사에 오류가 있는 경우, 주어진 객체에 이 오류들을 errors 에 등록
	@Override
	public void validate(Object target, Errors errors) {
		// 언제 호출되는지 확인
		System.out.println("validate()");
		

	}

}
