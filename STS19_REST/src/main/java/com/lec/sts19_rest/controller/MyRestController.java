package com.lec.sts19_rest.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.EmployeeListVO;
import com.lec.sts19_rest.board.beans.EmployeeVo;
import com.lec.sts19_rest.board.beans.IWriteDAO;

@RestController // rest 를 구현하는 요소중에 하나가 data 를 response 한다.
@RequestMapping("/MyRest")
public class MyRestController {
	
	// handler 만들기 
	@RequestMapping("/")
	public String helloTEXT() {
		return "Hello REST";
	}
	
	// 핸들러 추가 - 자바 객체 dto 를 return 하는 핸들러?!
	@RequestMapping("/helloJSON")
	public BWriteDTO helloJSON() {
		BWriteDTO dto = 
				new BWriteDTO(100, "안녕하세요", "REST", "JSON", 
						123, new Timestamp(10000));
		return dto;
	}
	
	// 핸들러 추가  - List 객체 return (json배열로 리턴)
	@RequestMapping("/listJSON")
	public List<BWriteDTO> listJSON(){
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		return dao.select();
	}
	
	
	// JSON 데이터를 자바배열로 .. 
	@RequestMapping("/arrJSON")
	public BWriteDTO[] arrJSON(){
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		List<BWriteDTO> list =  dao.select();
		BWriteDTO [] arr = new BWriteDTO[list.size()];
		return list.toArray(arr);
	}
	
	// JSON 데이터를 자바MAP<k, v>로...
	// map 을 return -> 그렇기때문에 object 로 return 된당
	@RequestMapping("/mapJSON")
	public Map<Integer, BWriteDTO> mapJSON(){
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		List<BWriteDTO> list = dao.select();
		
		Map<Integer, BWriteDTO> map = new HashMap<Integer, BWriteDTO>();
		
		for(BWriteDTO dto : list) {
			map.put(dto.getUid(), dto);
		}
		
		return map;
	}
	
	
	// ================= 자바 객체를 XML 데이터로 .... ============================//
	@RequestMapping("/helloXML")
	public EmployeeVo helloXML() {
		return
		new EmployeeVo(100, "홍길", 200, new int[] {10, 20,30}, 34.2);
	}
	
	// XML 데이터를 자바 List<> 
	@RequestMapping("/listXML")
	public EmployeeListVO listXML() {
		EmployeeListVO employees = new EmployeeListVO();
			
			EmployeeVo emp1 = new EmployeeVo(1, "조현주", 27, new int[] {78, 76, 29}, 34.2);
			EmployeeVo emp2 = new EmployeeVo(2, "현주조", 25, new int[] {87, 67, 92}, 34.2);
			EmployeeVo emp3 = new EmployeeVo(3, "주조현", 23, new int[] {76, 79, 97}, 34.2);
			
			employees.getEmployees().add(emp1);
			employees.getEmployees().add(emp2);
			employees.getEmployees().add(emp3);
			
		return employees;
	}
	
	

	@RequestMapping("/read/{uid}")
	public ResponseEntity<BWriteDTO> read(@PathVariable("uid") int uid) {
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		BWriteDTO dto = dao.selectByUid(uid);
		
		// 데이터를 잘 읽어들였는지 확인
		// 읽어들인 데이터가 null 이라면 ? 
		if(dto == null) return new ResponseEntity(HttpStatus.NOT_FOUND); // 404 
		
		// 성공한 케이스
		return new ResponseEntity<BWriteDTO>(dto, HttpStatus.OK); // 200
	}
	
}

