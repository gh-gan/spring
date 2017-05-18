package com.springboot.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.domain.Person;

//@RestController 等于  @Controller  @ResponseBody 合用  
@Controller  
public class HelloController {
	
	// Rustful 风格, springboot使用起来主要还是以提供接口方式（rustful）比较方便，其它使用起来还是不是很方便，什么都封装好了使用并不灵活。
	
	@RequestMapping("/")
	@ResponseBody    		 	// @ResponseBody 直接返回内容到页面，无此注解返回的值表示是 html/jsp 资源路径
	public String hello() {
		return "Hello World!";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public List list() {
		return new ArrayList(){{add("111111"); add("222222");}};
	} 
	
	// 返回 json/xml 格式，返回xml时在类上使用@XmlRootElement注解
	@RequestMapping("/person")
	@ResponseBody
	public Person getPersion() {
		return new Person("gh",26);
	}
	
	@RequestMapping("/index4")
	public String helloHtml3() {
		return "forward:/login.html"; 
	}
	
	// ----------------------------  下面测试未通过 
	// 返回 html 页面
	@RequestMapping("/index2")
	public String helloHtml() {
		return "index"; 
	}
	
}
