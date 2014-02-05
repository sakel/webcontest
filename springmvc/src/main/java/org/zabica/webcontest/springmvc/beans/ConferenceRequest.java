package org.zabica.webcontest.springmvc.beans;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.zabica.webcontest.common.venue.Conference;

public class ConferenceRequest {
	
	@NotBlank(message="{blank.value}")
	private String title;
	
	@NotBlank(message="{blank.value}")
	private String description;
	
	//Start date/hour
	@NotNull(message="{blank.value}")
	private Date start;
	
	//Duration of the venue in days
	@NotNull(message="{blank.value}")
	private Integer duration;
	
	//Last date when the registration is possible
	@NotNull(message="{blank.value}")
	private Date registrationDeadline;
	
	//Maximum number of attendees
	@NotNull(message="{blank.value}")
	@Min(value=1)
	private Integer maxAttendees;
	
	//Venue Fees
	@Min(value=0)
	private double fee;
	
	//Location
	@NotBlank(message="{blank.value}")
	private String location;

	//Tags
	@Size(min=1, message="{min.size}")
	private List<String> tags;

	public ConferenceRequest() {
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

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
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

	public Conference toConference() {
		Conference conf = new Conference();
		conf.setDescription(this.description);
		conf.setDuration(this.duration);
		conf.setFee(this.fee);
		conf.setLocation(this.location);
		conf.setMaxAttendees(this.maxAttendees);
		conf.setRegistrationDeadline(this.registrationDeadline);
		conf.setStart(this.start);
		conf.setTags(this.tags);
		conf.setTitle(this.title);
		return conf;
	}
	
}
