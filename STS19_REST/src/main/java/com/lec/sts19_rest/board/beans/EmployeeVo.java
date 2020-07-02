package com.lec.sts19_rest.board.beans;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="employee") // 이 클래스 데이터는 employee 라는 루트 태그로 만들어 진다는 의미 
public class EmployeeVo {
	
	@XmlAttribute //  <id> 의 attribute
	private Integer id;
	
	@XmlElement 	// <name> 의 element
	private String name;
	
	@XmlElement
	private int age;
	
	@XmlElement		// <score> 의 elements!
	private int[] score;
	
	//annotation 없으면 XML 변환에 포함되지 않는다. 
	private double point;
	
	
	public EmployeeVo() {
		super();
	}
	public EmployeeVo(Integer id, String name, int age, int[] score, double point) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.score = score;
		this.point = point;
	}
	
	// getter 생성 - setter 생성하지 않는다. (readonly의 기능 = immutable)
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int[] getScore() {
		return score;
	}
	public double getPoint() {
		return point;
	}
	
	
}
