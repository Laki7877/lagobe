package com.lagobe.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="amphur")
public class Amphur {
	
	@Id
	@Column(name="amphur_id")
	private Integer amphurId;
	
	@Column(name="amphur_code",length=4)
	private String amphurCode;
	
	@Column(name="amphur_name",length=150)
	private String amphurName;
	
	@Column(name="geo_id")
	private Integer geoId;
	
	@Column(name="province_id")
	private Integer provinceId;

	public Integer getAmphurId() {
		return amphurId;
	}

	public void setAmphurId(Integer amphurId) {
		this.amphurId = amphurId;
	}

	public String getAmphurCode() {
		return amphurCode;
	}

	public void setAmphurCode(String amphurCode) {
		this.amphurCode = amphurCode;
	}

	public String getAmphurName() {
		return amphurName;
	}

	public void setAmphurName(String amphurName) {
		this.amphurName = amphurName;
	}

	public Integer getGeoId() {
		return geoId;
	}

	public void setGeoId(Integer geoId) {
		this.geoId = geoId;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	
}
