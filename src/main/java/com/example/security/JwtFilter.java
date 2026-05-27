package com.example.security;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Override

	protected void doFilterInternal(HttpServletRequest req,

			HttpServletResponse res,

			FilterChain chain)

			throws ServletException, IOException {

		chain.doFilter(req, res);
	}
}