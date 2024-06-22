package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String showHome() {
		return "Home";
	}
	
	@GetMapping("/welcome")
	public String showWelcome() {
		return "Welcome";
	}
	 
	@GetMapping("/admin")
	public String showAdmin() {
		return "Admin";
	}
	
	@GetMapping("/emp")
	public String showEmp() {
		return "Employee";
	}
	
	@GetMapping("/std")
	public String showStd() {
		return "Student";
	}
	
	@GetMapping("/denied")
	public String showDenied() {
		return "Denied";
	}
	
}