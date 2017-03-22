package com.lagobe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.lagobe.daos.AmphurDao;
import com.lagobe.daos.BankDao;
import com.lagobe.daos.CompanyDao;
import com.lagobe.daos.DistrictDao;
import com.lagobe.daos.ProvinceDao;
import com.lagobe.daos.ZipcodeDao;
import com.lagobe.models.Amphur;
import com.lagobe.models.Bank;
import com.lagobe.models.Company;
import com.lagobe.models.District;
import com.lagobe.models.Province;
import com.lagobe.models.Zipcode;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/staticdata")
public class StaticData {
	
	
	@Autowired
	private CompanyDao companyDao;
	
	@Autowired
	private ZipcodeDao zipcodeDao;
	
	@Autowired
	private BankDao bankDao;
	
	@Autowired
	private ProvinceDao provinceDao;
	
	@Autowired
	private AmphurDao amphurDao;
	
	@Autowired
	private DistrictDao districtDao;
	
	
	@RequestMapping(value="/companies",method = RequestMethod.GET)
	@ApiOperation(value = "Get companies")
    public List<Company> getCompanies() throws Exception{
		return Lists.newArrayList(companyDao.findAll());
    }
	
	@RequestMapping(value="/banks",method = RequestMethod.GET)
	@ApiOperation(value = "Get banks")
    public List<Bank> getBanks() throws Exception{
		return Lists.newArrayList(bankDao.findAll());
    }
	
	@RequestMapping(value="/zipcodes",method = RequestMethod.GET)
	@ApiOperation(value = "Get zipcodes")
    public Page<Zipcode> getZipcodes(@RequestParam(name="search", required=false) String search, Pageable pageable) throws Exception{
		return zipcodeDao.findByZipcodeStartingWith(search, pageable);
    }
	
	@RequestMapping(value="/province/{provinceid}",method = RequestMethod.GET)
	@ApiOperation(value = "Get province")
    public Province getProvince(@PathVariable Integer provinceid) throws Exception{
		return provinceDao.findOne(provinceid);
    }
	
	@RequestMapping(value="/amphur/{amphurid}",method = RequestMethod.GET)
	@ApiOperation(value = "Get amphur")
    public Amphur getAmphur(@PathVariable Integer amphurid) throws Exception{
		return amphurDao.findOne(amphurid);
    }
	
	
	@RequestMapping(value="/district/{districtid}",method = RequestMethod.GET)
	@ApiOperation(value = "Get district")
    public District getDistrict(@PathVariable Integer districtid) throws Exception{
		return districtDao.findOne(districtid);
    }
	

}
