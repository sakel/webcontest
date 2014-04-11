package org.zabica.webcontest.tapestry.pages;

import java.util.List;

import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.zabica.webcontest.common.venue.Conference;

public class Conferences {
	
	@Parameter
	private String tags;
	
	@Parameter
	private String date;

	private List<Conference> conferences;
	
	@Property
	private Conference _conference;
	
	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<Conference> getConferences() {
		return conferences;
	}

	public void setConferences(List<Conference> conferences) {
		this.conferences = conferences;
	}
}
