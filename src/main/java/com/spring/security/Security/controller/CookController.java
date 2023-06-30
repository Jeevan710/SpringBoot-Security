package com.spring.security.Security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.Security.Bean.AuthRequest;
import com.spring.security.Security.JWT.JwtService;
import com.spring.security.Security.dao.UserDAO;
import com.spring.security.Security.entity.UserEntity;


@RestController
public class CookController {
	
	@Autowired
	private UserDAO uBean;
	@Autowired
	private JwtService jwtService;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@RequestMapping(value="/" ,method=RequestMethod.GET)
	public String index()
	{
		return "Welcome";
	}

	@RequestMapping(value = "/moderator",method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ROLE_MODERATOR')")
	public String getModerator()
	{
		return "Moderator";
				
	}
	@RequestMapping(value = "/admin",method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String getAdmin()
	{
		return "Admin";
	}
	@RequestMapping(value = "/user",method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String getUser()
	{
		return "User";
	}
	
	@RequestMapping(value="/auth",method=RequestMethod.POST)
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest)
	{
		Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(),authRequest.getPassword()));
		if(authentication.isAuthenticated())
		{
			return jwtService.generateToken(authRequest.getUserName());
		}
		else
		{
			throw new UsernameNotFoundException("Invalid credentials");	
		}
		
	}
}