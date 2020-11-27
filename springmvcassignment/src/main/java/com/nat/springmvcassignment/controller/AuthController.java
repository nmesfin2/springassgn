package com.nat.springmvcassignment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nat.springmvcassignment.model.Login;
import com.nat.springmvcassignment.repository.LoginRepository;
import com.nat.springmvcassignment.repository.RegistrationRepository;

@Controller
@RequestMapping(path="/auth")
public class AuthController {
	
	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
	RegistrationRepository registrationRepository;
	
	@GetMapping("/login.html")
	public String getLoginPage() {
		return "login";
	}
	
	@PostMapping("/login.html")
	public ModelAndView validateLogin(@ModelAttribute @Valid Login login, BindingResult result) {
		System.out.println("hello from validatelogin"+login);
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()) {
			result.getFieldErrors().forEach(e->{
				modelAndView.addObject(e.getField(), e.getDefaultMessage());
				System.out.println(e.getDefaultMessage() + " "+ e.getField());

			});
			modelAndView.setViewName("login");
			return modelAndView;
		}else {
			String rUserName = registrationRepository.findById(login.getUserName()).get().getUserName();
			String rPassword = registrationRepository.findById(login.getUserName()).get().getPassword();
			if(login.getUserName().equals(rUserName) && login.getPassword().equals(rPassword))  {
				System.out.println("success");
				modelAndView.setViewName("home");
				return modelAndView;
			}
			else {
				System.out.println("fail");
				modelAndView.setViewName("login");
				return modelAndView;
			}
		}
	}
}
