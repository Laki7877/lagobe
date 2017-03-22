package com.lagobe.daos;

import org.springframework.data.repository.CrudRepository;

import com.lagobe.models.Bank;

public interface BankDao extends CrudRepository<Bank, String> {

}
