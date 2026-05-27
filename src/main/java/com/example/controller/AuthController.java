package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.dto.AuthResponse;
import com.example.dto.LoginRequest;
import com.example.entity.User;
import com.example.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService service;

	@PostMapping("/register")
	public User register(@RequestBody User user) {

		return service.register(user);
	}

	@PostMapping("/login")
	public AuthResponse login(@RequestBody LoginRequest req) {

		String token = service.login(req);

		return new AuthResponse(token);
	}
}