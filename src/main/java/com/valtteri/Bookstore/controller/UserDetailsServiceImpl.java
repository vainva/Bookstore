package com.valtteri.Bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.valtteri.Bookstore.bean.User;
import com.valtteri.Bookstore.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private final UserRepository repository;
	
	@Autowired
	public UserDetailsServiceImpl(UserRepository userRepository) {
	this.repository = userRepository;
	
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User currentUser = repository.findByUsername(username);
	UserDetails user = new org.springframework.security.core.userdetails.User(username,
	currentUser.getPasswordHash(),
	AuthorityUtils.createAuthorityList(currentUser.getRole()));
	return user;
}
}