package com.anurag.wordservice.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anurag.wordservice.demo.dto.AuthResponse;
import com.anurag.wordservice.demo.service.AuthService;
import com.nimbusds.jose.KeyLengthException;

@RestController
public class AuthUtilController {
	
	@Autowired
	private AuthService authService;
	
	@GetMapping("/token")
	public AuthResponse getToken() throws KeyLengthException{
		return authService.getTableauToken();
	}
}
