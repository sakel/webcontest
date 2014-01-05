package org.zabica.webcontest.common.venue;

import java.io.Serializable;

public class EventRoom implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6087998160310494300L;

	private LocationAddress complex;
	private String roomName;
	private Integer size;
	
	public LocationAddress getComplex() {
		return complex;
	}
	public void setComplex(LocationAddress complex) {
		this.complex = complex;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
}
