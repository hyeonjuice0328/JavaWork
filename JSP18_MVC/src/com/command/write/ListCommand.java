package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class ListCommand implements Command {
	// ListCommand 의 execute 가 언제 실행되는가? 
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		WriteDAO dao = new WriteDAO(); // DAO 객체 생성
		WriteDTO [] arr = null; // 결과를 받을 배열
		
		try {
			// 트렌젝션 수행
			arr = dao.select();
			
			request.setAttribute("list", arr);
			// 수행결과 arr 을 list 라는 이름으로 담는다. 
			// "list"라는 name 으로 request 에 arr 전달
			// 즉 request에 담아서 controller 에 전달되는 셈.
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
