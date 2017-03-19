package com.lagobe.daos;

import org.springframework.data.repository.CrudRepository;

import com.lagobe.models.Resource;

public interface ResourceDao extends CrudRepository<Resource, Long> {

}
