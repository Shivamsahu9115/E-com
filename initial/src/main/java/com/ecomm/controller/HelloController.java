package com.ecomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.entity.User;
import com.ecomm.service.UserService;

@Controller
public class HelloController {

	@Autowired
	private UserService service;
	
	

	@RequestMapping("/")
	public String index() {
		
		return "home";
	}
	
	
	@PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String home(@RequestBody User user) {
		this.service.saveUser(user);
		return "home";
	}

}
