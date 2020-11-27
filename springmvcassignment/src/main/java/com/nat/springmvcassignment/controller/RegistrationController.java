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

import com.nat.springmvcassignment.model.Registration;
import com.nat.springmvcassignment.repository.RegistrationRepository;

@Controller
@RequestMapping(path="/registration")
public class RegistrationController {

	@Autowired
	RegistrationRepository registrationRepository;
	
	@GetMapping("/adduser")
	public String getRegistrationPage() {
		return "registration";
	}
	
	@PostMapping("/adduser")	
	public ModelAndView RegistarUser(@ModelAttribute @Valid Registration registration, BindingResult result) {
		System.out.println("hello from registration controller"+registration);
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()) {
			result.getFieldErrors().forEach(e->{
				modelAndView.addObject(e.getField(), e.getDefaultMessage());
				System.out.println(e.getDefaultMessage() + " "+ e.getField());

			});

			modelAndView.setViewName("registration");
			return modelAndView;
		}else {
			registrationRepository.save(registration);
			modelAndView.setViewName("login");
			return modelAndView;
		}
	}
}
