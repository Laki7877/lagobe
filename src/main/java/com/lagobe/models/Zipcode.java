package com.lagobe.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="zipcode")
public class Zipcode {
	
	@Id
	@Column(name="zipcode_id")
	private Integer zipcodeId;
	
	@Column(name="district_code",length=100)
	private String districtCode;
	
	@Column(name="province_id")
	private Integer provinceId;
	
	@Column(name="amphur_id")
	private Integer amphurId;
	
	@Column(name="district_id")
	private Integer districtId;
	
	@Column(name="zipcode",length=5)
	private String zipcode;

	public Integer getZipcodeId() {
		return zipcodeId;
	}

	public void setZipcodeId(Integer zipcodeId) {
		this.zipcodeId = zipcodeId;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getAmphurId() {
		return amphurId;
	}

	public void setAmphurId(Integer amphurId) {
		this.amphurId = amphurId;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	

}
