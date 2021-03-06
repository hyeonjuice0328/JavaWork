package com.lec.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormOk")
public class ServletForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletForm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request.getParameterNames()
				System.out.println("getParameterNames() 사용");
				Enumeration<String> names = request.getParameterNames(); // 여러개가 담겨있는 컬렉션
				while(names.hasMoreElements()) {
					String paramName = names.nextElement();
					String paramValue = request.getParameter(paramName);
					System.out.println(paramName + " : " + paramValue);
				}
				
				System.out.println("getParameterMap() 사용");
				Map<String, String[]> paramMap = request.getParameterMap();
				for(String key : paramMap.keySet()) {
					System.out.println(key + " : " + Arrays.toString(paramMap.get(key)));
				}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//getParameter 는 String type return
		//String 임의지정 = request.getParameter("html파일에 있는 객체의 name");
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// getParameterValues 는 배열타입 리턴 (값이 하나여도) 
		String [] hobbys = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");
		String local = request.getParameter("local");
		String memo = request.getParameter("memo");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head></head>");
		
		out.println("<body>");
		
		out.println("hidden: " + data1 + ", " + data2 + "<br>");
		out.println("이름: " + name + "<br>");
		out.println("아이디: " + id + "<br>");
		out.println("비밀번호: " + pw + "<br>");
		
		out.println("취미: " + Arrays.toString(hobbys) + "<br>");
		out.println("성별: " + gender + "<br>");
		out.println("지역: " + local + "<br>");
		out.println("메모: " + memo + "<br>");
		
		out.println("</body>");
		
		out.println("</html>");
		
		out.close();
		
		// request.getParameterNames()
		System.out.println("getParameterNames() 사용");
		Enumeration<String> names = request.getParameterNames(); // 여러개가 담겨있는 컬렉션
		while(names.hasMoreElements()) {
			String paramName = names.nextElement();
			String paramValue = request.getParameter(paramName);
			System.out.println(paramName + " : " + paramValue);
		}
		
		System.out.println("getParameterMap() 사용");
		Map<String, String[]> paramMap = request.getParameterMap();
		for(String key : paramMap.keySet()) {
			System.out.println(key + " : " + Arrays.toString(paramMap.get(key)));
		}
	}}
