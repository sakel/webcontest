package org.zabica.webcontest.common.venue;

import java.io.Serializable;

public class Lecturer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2283629629494229507L;

	private String name;
	private String lastName;
	private String biography;
	private String company;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
}
