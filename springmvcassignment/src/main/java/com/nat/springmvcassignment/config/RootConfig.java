package com.nat.springmvcassignment.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc // it will enable the mvc env (@requestbaody, controller , response body, requestmapping, @valid
@ComponentScan("com.nat.springmvcassignment")
public class RootConfig {

}
