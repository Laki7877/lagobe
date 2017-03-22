package com.lagobe.daos;

import org.springframework.data.repository.CrudRepository;

import com.lagobe.models.Company;

public interface CompanyDao extends CrudRepository<Company, Long> {

}
