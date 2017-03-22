package com.lagobe.daos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.lagobe.models.Zipcode;

public interface ZipcodeDao extends CrudRepository<Zipcode, Integer> {
	
	public Page<Zipcode> findByZipcodeStartingWith(String zipcode, Pageable pageable);

}
