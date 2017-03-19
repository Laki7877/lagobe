package com.lagobe.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lagobe.models.Resource;
import com.lagobe.requests.ResourceRemoteRequest;

@Service
public interface ResourceService {
	public Resource getById(Long id)  throws Exception;
	public String generateResourceName(String filename) throws Exception;
	public Resource upload(MultipartFile multipartFile) throws Exception;
	public Resource upload(ResourceRemoteRequest request) throws Exception;
}
