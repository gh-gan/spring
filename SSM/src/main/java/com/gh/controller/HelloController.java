package com.gh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@RequestMapping("/getPerson.do")
	@ResponseBody
	public String getPerson(){
		return "person";
	}
	
	@RequestMapping("/getIndex.do")
	public String getIndex(){
		return "index";
	}
}
