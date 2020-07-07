package com.lec.sts18_security.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomNoOpPasswordEncoder implements PasswordEncoder {

	// 주어진 rawPassword 를 인코딩 하여 리턴, 일반적으로 SHA-1 혹은 그 이상의 암호화 알고리즘 사용
	@Override
	public String encode(CharSequence rawPassword) {
		System.out.println("encode 전 : " + rawPassword);
		return rawPassword.toString();
	}

	@Override	// 주어진 패스워드와 인코딩된 패스워드를 비교하여 같으면 true 다르면 false 를 return 
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		System.out.println("matches 수행 : " + rawPassword + "::" + encodedPassword);
		return rawPassword.toString().equals(encodedPassword);
	}

}
