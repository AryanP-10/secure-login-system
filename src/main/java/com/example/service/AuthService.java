package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dto.LoginRequest;
import com.example.entity.User;
import com.example.exception.UnauthorizedException;
import com.example.repository.UserRepository;
import com.example.security.JwtUtil;

@Service
public class AuthService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private JwtUtil jwtUtil;

	public User register(User user) {

		user.setPassword(encoder.encode(user.getPassword()));

		return repository.save(user);
	}

	public String login(LoginRequest req) {

		User user = repository.findByUsername(req.getUsername())

				.orElseThrow(() -> new UnauthorizedException("Invalid username"));

		boolean match = encoder.matches(req.getPassword(), user.getPassword());

		if (!match) {

			throw new UnauthorizedException("Invalid password");
		}

		return jwtUtil.generateToken(user.getUsername());
	}
}