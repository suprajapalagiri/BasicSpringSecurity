package com.ojas.employee.model;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
	@Autowired
	Employee employee;
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return employee.getRoles().stream().map(role->new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
	}

	public CustomUserDetails(Employee employee) {
		super();
		this.employee = employee;
	}

	@Override
	public String getPassword() {
		return employee.getPassword();
	}

	@Override
	public String getUsername() {
		
		return employee.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
