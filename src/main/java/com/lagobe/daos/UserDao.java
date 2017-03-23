package com.lagobe.daos;

import org.springframework.data.repository.CrudRepository;

import com.lagobe.models.User;

public interface UserDao extends CrudRepository<User, Long> {
	
	public Long countByEmail(String email);
	public User findOneByEmail(String email);
}
