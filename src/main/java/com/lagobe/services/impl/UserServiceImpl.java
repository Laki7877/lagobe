package com.lagobe.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lagobe.daos.UserDao;
import com.lagobe.exceptions.ResponseException;
import com.lagobe.models.User;
import com.lagobe.services.UserService;
import com.lagobe.utils.EncryptionUtil;
import com.mysql.jdbc.StringUtils;


@Component
@Transactional(rollbackFor=Exception.class)
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private EncryptionUtil encryptionUtil;

	@Override
	public User addUser(User user) throws Exception {
		
		if(StringUtils.isNullOrEmpty(user.getFirstName())){
			throw new ResponseException(HttpStatus.BAD_REQUEST,"error.user.empty.firstname");
		}
		if(user.getFirstName().length() > 100){
			throw new ResponseException(HttpStatus.BAD_REQUEST,"error.user.exceed.firstname");
		}
		if(StringUtils.isNullOrEmpty(user.getLastName())){
			throw new ResponseException(HttpStatus.BAD_REQUEST,"error.user.empty.lastname");
		}
		if(user.getLastName().length() > 100){
			throw new ResponseException(HttpStatus.BAD_REQUEST,"error.user.exceed.lastname");
		}
		if(StringUtils.isNullOrEmpty(user.getEmail())) {
			throw new ResponseException(HttpStatus.BAD_REQUEST,"error.user.empty.email");
		}
		if(user.getEmail().length() > 100){
			throw new ResponseException(HttpStatus.BAD_REQUEST,"error.user.exceed.email");
		}
		if(userDao.countByEmail(user.getEmail()) > 0){
			throw new ResponseException(HttpStatus.BAD_REQUEST,"error.user.duplicate.email");
		}
		if(user.getPhone().length() > 20){
			throw new ResponseException(HttpStatus.BAD_REQUEST,"error.user.exceed.phone");
		}
		if(StringUtils.isNullOrEmpty(user.getPassword())){
			throw new ResponseException(HttpStatus.BAD_REQUEST,"error.user.empty.password");
		}
		if(user.getPassword().length() > 32){
			throw new ResponseException(HttpStatus.BAD_REQUEST,"error.user.exceed.password");
		}
		
		user.setPassword(encryptionUtil.hashPassword(user.getPassword()));
		user = userDao.save(user);
		return user;
	}

}
