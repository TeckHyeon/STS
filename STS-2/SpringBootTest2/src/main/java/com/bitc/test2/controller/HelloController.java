package com.bitc.test2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String hello() {
		return "Hello World!";
	}
	
	@RequestMapping("test")
	public String test() {
		return "test page";
	}
}
