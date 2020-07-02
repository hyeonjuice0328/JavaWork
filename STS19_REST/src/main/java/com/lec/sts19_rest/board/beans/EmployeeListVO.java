package com.lec.sts19_rest.board.beans;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="employees")
public class EmployeeListVO {
	
	//List 멤버 
	@XmlElement
	private List<EmployeeVo> emp
		= new ArrayList<EmployeeVo>();

	
	
	public List<EmployeeVo> getEmployees() {
		return emp;
	}
	
	
	

}
