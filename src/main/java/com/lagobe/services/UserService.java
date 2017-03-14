package com.lagobe.services;

import org.springframework.stereotype.Service;

import com.lagobe.models.User;

@Service
public interface UserService {
	
	public User addUser(User user) throws Exception;

}
