package com.lagobe.services;

import org.springframework.stereotype.Service;

import com.lagobe.models.User;

@Service
public interface UserService {
	
	public User addUser(User user) throws Exception;
	public User updateUser(Long userId,User user) throws Exception;
	public User authenthication(String email, String password) throws Exception;

}
