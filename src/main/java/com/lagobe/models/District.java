package com.lagobe.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="district")
public class District {
	
	
	@Id
	@Column(name="district_id")
	private Integer districtId;
	
	@Column(name="district_code",length=6)
	private String districtCode;
	
	@Column(name="district_name",length=150)
	private String districtName;
	
	@Column(name="amphur_id")
	private Integer amphurId;
	
	
	@Column(name="province_id")
	private Integer provinceId;
	
	@Column(name="geo_id")
	private Integer geoId;

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public Integer getAmphurId() {
		return amphurId;
	}

	public void setAmphurId(Integer amphurId) {
		this.amphurId = amphurId;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getGeoId() {
		return geoId;
	}

	public void setGeoId(Integer geoId) {
		this.geoId = geoId;
	}
	
}
