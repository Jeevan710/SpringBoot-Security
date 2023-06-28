package com.spring.security.Security.Config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.security.Security.entity.UserEntity;

public class UserInfoUserDetails implements UserDetails{
	
	  private Long id;

	  private String username;

	  private String email;

	  private String password;

	  private Collection<? extends GrantedAuthority> authorities;

	
	public UserInfoUserDetails(Long id, String username, String email, String password,
		      Collection<? extends GrantedAuthority> authorities) {
	    this.id = id;
	    this.username = username;
	    this.email = email;
	    this.password = password;
	    this.authorities = authorities;
	}
	
	public static UserInfoUserDetails build(UserEntity user)
	{
		List<GrantedAuthority> authorities=user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getRole().name())).collect(Collectors.toList());
		return new UserInfoUserDetails(user.getId(),user.getUserName(),user.getEmail(),user.getPassword(),authorities);
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
