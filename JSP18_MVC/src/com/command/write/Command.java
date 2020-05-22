package com.command.write;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	// 추상 메소드 
	void execute(HttpServletRequest request, HttpServletResponse response);
}
