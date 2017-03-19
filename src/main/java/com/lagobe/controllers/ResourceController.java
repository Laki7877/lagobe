package com.lagobe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lagobe.exceptions.ResponseException;
import com.lagobe.models.Resource;
import com.lagobe.requests.ResourceRemoteRequest;
import com.lagobe.services.ResourceService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/resource")
public class ResourceController {
	@Autowired
	private ResourceService resourceService;
	@RequestMapping(method=RequestMethod.PUT)
	@ApiOperation(value = "Upload file")
	public Resource createResource(@RequestBody MultipartFile file) throws Exception{
		return resourceService.upload(file);
	}
	@RequestMapping(value="/remote",method=RequestMethod.PUT)
	@ApiOperation(value = "Upload file from url")
	public Resource createResource(@RequestBody ResourceRemoteRequest request) throws Exception {
		return resourceService.upload(request);
	}
	@RequestMapping(value="/{resourceId}",method=RequestMethod.GET)
	@ApiOperation(value = "Get a file")
	public Resource getOneResource(@PathVariable Long resourceId) throws Exception{
		throw new ResponseException();
	}
	@RequestMapping(value="/{resourceId}",method=RequestMethod.POST)
	@ApiOperation(value = "Update a file")
	public Resource updateResource(@PathVariable Long resourceId,@RequestBody Resource resource) throws Exception{
		throw new ResponseException("error.notimplement");
	}
	@RequestMapping(value="/{resourceId}",method=RequestMethod.DELETE)
	@ApiOperation(value = "Delete a file")
	public void deleteResource(@PathVariable Long resourceId) throws Exception{
		throw new ResponseException("error.notimplement");
	}

}
