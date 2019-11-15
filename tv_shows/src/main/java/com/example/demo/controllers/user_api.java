//package com.example.demo.controllers;
//
//import java.util.List;
//
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.models.user;
//import com.example.demo.services.user_services;
//
//@RestController
//public class user_api {
//	private final user_services user_serve;
//
//	public user_api(user_services user_serve) {
//		this.user_serve = user_serve;
//	}
//
//	@RequestMapping("/test")
//	public String home() {
//		return "Home";
//	}
//
//	@RequestMapping("/api/allusers")
//	public List<user> index() {
//		return user_serve.allUsers();
//	}
//
//	@RequestMapping(value = "/api/newuser", method = RequestMethod.POST)
//	public user create(@RequestParam(value = "username") String username, @RequestParam(value = "email") String email,
//			@RequestParam(value = "password") String password) {
//		user newuser = new user(username, email, password);
//		return user_serve.createUser(newuser);
//	}
//
//	@RequestMapping("/api/users/{id}")
//	public user showUser(@PathVariable("id") Long id) {
//		user one = user_serve.findUser(id);
//		return one;
//	}
//}
