package com.lagobe.services;

import org.springframework.stereotype.Service;

import com.lagobe.models.Shop;

@Service
public interface ShopService {
	
	public Shop addShop(Shop shop) throws Exception;
}
