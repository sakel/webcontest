package org.zabica.webcontest.common.venue;

import java.io.Serializable;

public class LocationAddress implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3723129711834541732L;

	private String locationLine1;
	private String locationLine2;
	private String city;
	private String country;
	
	public String getLocationLine1() {
		return locationLine1;
	}
	public void setLocationLine1(String locationLine1) {
		this.locationLine1 = locationLine1;
	}
	public String getLocationLine2() {
		return locationLine2;
	}
	public void setLocationLine2(String locationLine2) {
		this.locationLine2 = locationLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
