package com.TradeMicro.TAM.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthStatusController {
	
	@GetMapping("/login-success")
	public String loginSuccess() {
		
		return "Login Success via GitHub";
		
	}
	@GetMapping("/logout-success")
	public String logoutSuccess() {
		return "Logout Sucess";
	}
	
}
