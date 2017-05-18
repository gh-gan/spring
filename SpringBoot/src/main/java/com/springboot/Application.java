package com.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.springboot.controller")   //@ComponentScan(basePackages = {"com.springboot.controller"}) 指定springmvc扫描包
*/
// @SpringBootApplication 相当于同时使用  @Configuration @EnableAutoConfiguration @ComponentScan
@SpringBootApplication     
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
