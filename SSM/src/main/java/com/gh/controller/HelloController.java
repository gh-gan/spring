package com.gh.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gh.domain.PersonDO;
import com.gh.service.PersionService;

@Controller
public class HelloController {
	
	@Resource
	private PersionService persionService;

	@RequestMapping("/getRestFul.do")
	@ResponseBody
	public String getRestFul(){
		return "hello restful";
	}
	
	@RequestMapping("/getIndex.do")
	public String getIndex(){
		return "index";
	}
	
	@RequestMapping("/getPerson.do")
	@ResponseBody
	public PersonDO getPerson(){
		PersonDO person = this.persionService.getPersonByName("ggh");
		return person;
	}
}
