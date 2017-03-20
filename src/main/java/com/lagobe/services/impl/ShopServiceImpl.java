package com.lagobe.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lagobe.daos.ShopDao;
import com.lagobe.models.Shop;
import com.lagobe.services.ShopService;


@Component
@Transactional(rollbackFor=Exception.class)
public class ShopServiceImpl implements ShopService {
	
	
	@Autowired
	private ShopDao shopDao;

	@Override
	public Shop addShop(Shop shop) throws Exception {
		
		return shopDao.save(shop);
	}

}
