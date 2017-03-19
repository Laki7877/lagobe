package com.lagobe.daos;

import org.springframework.data.repository.CrudRepository;

import com.lagobe.models.Shop;

public interface ShopDao extends CrudRepository<Shop, Long> {

}
