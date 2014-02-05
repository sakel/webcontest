package org.zabica.webcontest.common.venue;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class Venue implements Serializable,Comparable<Venue> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7797391270084855256L;

	private String id;
	
	private String title;
	private String description;
	
	//Start date/hour
	@DateTimeFormat
	private Date start;
	
	//Duration of the venue in days
	private Integer duration;
	
	//Last date when the registration is possible
	@DateTimeFormat
	private Date registrationDeadline;
	
	//Maximum number of attendees
	private Integer maxAttendees;
	
	//Venue Fees
	@NumberFormat
	private double fee;
	
	//Location
	private String location;

	//Tags
	private List<String> tags;
	
	public Venue() {
		this.id = UUID.randomUUID().toString();
	}
	
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Date getRegistrationDeadline() {
		return registrationDeadline;
	}
	public void setRegistrationDeadline(Date registrationDeadline) {
		this.registrationDeadline = registrationDeadline;
	}
	public Integer getMaxAttendees() {
		return maxAttendees;
	}
	public void setMaxAttendees(Integer maxAttendees) {
		this.maxAttendees = maxAttendees;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	@Override
	public int compareTo(Venue o) {
		if(this.start.before(o.getStart())) {
			return -1;
		} else if(this.start.after(o.getStart())) {
			return 1;
		}
		return 0;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
