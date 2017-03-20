package com.lagobe.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lagobe.models.Shop;
import com.lagobe.services.ShopService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/shop")
public class ShopController {
	
	
	@Autowired
	private ShopService shopService;
	
	@RequestMapping(method = RequestMethod.PUT)
	@ApiOperation(value = "Add new shop")
    public Shop addShop(@Valid @RequestBody Shop shop) throws Exception{
		return shopService.addShop(shop);
    }

}
