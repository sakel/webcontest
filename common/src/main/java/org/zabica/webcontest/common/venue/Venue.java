package org.zabica.webcontest.common.venue;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Venue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7797391270084855256L;

	//Start date/hour
	private Date start;
	//Duration of the venue in days
	private Integer duration;
	//Last date when the registration is possible
	private Date registrationDeadline;
	//Maximum number of attendees
	private Integer maxAttendees;
	
	//Venue Fees
	private List<VenueFee> fees;
	
	//Location
	private LocationAddress location;

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
	public LocationAddress getLocation() {
		return location;
	}
	public void setLocation(LocationAddress location) {
		this.location = location;
	}
	public List<VenueFee> getFees() {
		return fees;
	}
	public void setFees(List<VenueFee> fees) {
		this.fees = fees;
	}
}
