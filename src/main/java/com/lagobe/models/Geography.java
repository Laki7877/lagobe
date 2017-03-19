package com.lagobe.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="geography")
public class Geography {
	
	@Id
	@Column(name="geo_id")
	private Integer geoId;
	
	@Column(name="geo_name",length=255)
	private String districtCode;

	public Integer getGeoId() {
		return geoId;
	}

	public void setGeoId(Integer geoId) {
		this.geoId = geoId;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

}
