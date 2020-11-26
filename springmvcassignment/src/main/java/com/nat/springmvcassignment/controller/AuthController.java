package com.nat.springmvcassignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nat.springmvcassignment.model.Login;
import com.nat.springmvcassignment.repository.LoginRepository;

@Controller
@RequestMapping(path="/auth")
public class AuthController {
	
	@Autowired
	LoginRepository loginRepository;
	
	@GetMapping("/login.html")
	public String getLoginPage() {
		return "login";
	}
	
	@PostMapping("/login.html")
	public String validateLogin(@ModelAttribute Login login) {
		System.out.println("hello from validatelogin"+login);
		if(login.equals(loginRepository.findById(login.getUserName()).get())) {
			System.out.println("success");
		}
		else {
			System.out.println("fail");
		}
		return "home";
	}
}
