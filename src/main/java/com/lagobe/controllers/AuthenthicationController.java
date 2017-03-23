package com.lagobe.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lagobe.models.User;
import com.lagobe.requests.AuthenthicationRequest;
import com.lagobe.services.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/authenthication")
public class AuthenthicationController {
	
	@Autowired
	private UserService userService;
	
	
	
	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Update user")
	public User authenthication(@Valid @RequestBody AuthenthicationRequest request) throws Exception{
		return userService.authenthication(request.getEmail(),request.getPassword());
	}

}
