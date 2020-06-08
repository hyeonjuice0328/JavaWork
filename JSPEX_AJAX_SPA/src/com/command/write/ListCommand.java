package com.command.write;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class ListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		WriteDAO dao = new WriteDAO();  // DAO 객체 생성
		WriteDTO [] arr = null;  
		
		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";   // 기본 FAIL
		
		// 페이지 관련 셋팅값들
		int page = 1; // 현재 페이지 (default = 1page)
		int pageRows = 8; // 한페이지에 몇개의 글 (디폴트8개로 임의 설정)
		int writePages = 10; // 한 페이징에 몇개의 페이지 (디폴트10페이지)
		int totalCnt = 0;	// 글의 총 갯수
		int totalPage = 0;	// 페이지의 총 갯수 
		
		
		// parameter 는 String type return parameter 값이 없으면 null return 
		// 그래서 검증을 해야 한다. 
		String param;
		// page 값 : 현재 몇 페이지인지 
		param = request.getParameter("page");
		if(param != null && param.trim().length() != 0) {
			// param 이 null 도 아니고 비어있는 문자열도 아닌 경우 
			try { // 잘 작동되는지 확인하기 위해 try~catch문사용
			page = Integer.parseInt(param);
			}catch(NumberFormatException e) {
				// 예외처리하지 않는다. 성공하지 못하면 default 값 1로 동작한다. 
			}
		}
		// pageRows 값 : 한 페이지에 몇개의 글이 있는지 
		param = request.getParameter("pageRows");
		if(param != null && param.trim().length() != 0) {
			// param 이 null 도 아니고 비어있는 문자열도 아닌 경우 
			try { // 잘 작동되는지 확인하기 위해 try~catch문사용
			pageRows = Integer.parseInt(param);
			}catch(NumberFormatException e) {
				// 예외처리하지 않는다. 성공하지 못하면 default 값 1로 동작한다. 
			}
		}
		
		try {
			// 글 전체 개수 구하기 
			totalCnt = dao.countAll();
			
			// 총 몇 페이지 분량인가? 
			totalPage = (int)Math.ceil(totalCnt / (double)pageRows);
			
			// 몇번째 Row 부터? 
			int fromRow = (page - 1) * pageRows + 1;
			
			// oracle 은 rownum 이 1부터 시작 mysql 은 rownum 이 0부터 시작
			//int fromRow = (page - 1) * pageRows + 1;
			
			dao = new WriteDAO();
			arr = dao.selectFromRow(fromRow, pageRows);
			
			if(arr == null) { // 값이 0인건 상관없지만 null 인경우에는 fail 로..
				message.append("[리스트할 데이터가 없습니다.]");
			} else {
				status = "OK";
			}
			
		} catch(SQLException e) {
		  //e.printStackTrace();
			message.append("[트랜젝션 에러:" + e.getMessage() + "]");
		} // end try
		
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());
		request.setAttribute("list", arr);
		
		request.setAttribute("page", page);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("writePages", writePages);
		request.setAttribute("pageRows", pageRows);
		request.setAttribute("totalCnt", totalCnt);
		
		
	} // end execute()
} // end Command












