package com.lagobe.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lagobe.models.User;
import com.lagobe.services.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.PUT)
	@ApiOperation(value = "Add new user")
    public User addUser(@Valid @RequestBody User user) throws Exception{
		return userService.addUser(user);
    }

}
