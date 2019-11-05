package com.dojo.firstproject.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class home {
	@RequestMapping("/")
	public String greet() {
		return "this is the root route";
	}
	
	@RequestMapping("/random")
	public String random() {
		return "this is random";
	}
}
