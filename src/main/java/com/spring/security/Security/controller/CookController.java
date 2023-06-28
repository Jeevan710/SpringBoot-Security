package com.spring.security.Security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.Security.dao.UserDAO;
import com.spring.security.Security.entity.UserEntity;


@RestController
public class CookController {
	
@Autowired
private UserDAO uBean;
	
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
	
}