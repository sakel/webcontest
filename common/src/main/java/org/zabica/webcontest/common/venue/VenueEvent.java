package org.zabica.webcontest.common.venue;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class VenueEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3462195627100787840L;

	private String title;
	private String description;
	private Lecturer lecturer;
	private Date start;
	private EventRoom room;
	private List<String> tags;
	
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

	public EventRoom getRoom() {
		return room;
	}
	public void setRoom(EventRoom room) {
		this.room = room;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public Lecturer getLecturer() {
		return lecturer;
	}
	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}
}
