package org.zabica.webcontest.common.venue;

import java.util.Date;
import java.util.Map;

public class Conference extends Venue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5308973239031245912L;

	private Map<Date, VenueEvent> events;

	public Map<Date, VenueEvent> getEvents() {
		return events;
	}

	public void setEvents(Map<Date, VenueEvent> events) {
		this.events = events;
	}
}
