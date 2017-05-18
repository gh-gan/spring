package com.springboot.domain;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.web.bind.annotation.ResponseBody;

//@XmlRootElement  	 // 返回到页面时以xml结构显示，默认json格式
public class Person {
	private String name;
	private Integer age;
	
	public Person() {	}
	
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
