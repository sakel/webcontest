package org.zabica.webcontest.tapestry.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zabica.webcontest.common.venue.Conference;

public class Conferences extends BasePage {
	
	private static Logger LOG = LoggerFactory.getLogger(Conferences.class);
	
	@Property
	private List<String> tags;
	
	@Property
	private String date;

	@InjectComponent
	private TextField dateField;
	
	private List<Conference> conferences;
	
	@Property
	private Conference _conference;

	@Component
	private Form filter;
	
	private Date filterDate;
	
	public void onActivate() {
		LOG.debug("ON FILTER");
		
		if((tags == null || tags.isEmpty()) && (date == null || date.isEmpty())) {
			//this.conferences = this.dataStore.getConferences(null, null);
		}
	}
	
	public void onValidateFromFilter() {
		if(this.date == null) {
			this.filterDate = null;
			return;
		}
		
		String df = componentResources.getMessages().get("date.format");
		SimpleDateFormat sdf = new SimpleDateFormat(df);
		
		LOG.debug("Date: " + this.date);
		
		try {
			this.filterDate = sdf.parse(this.date);
		} catch (ParseException e) {
			filter.recordError(dateField, componentResources.getMessages().get("dateField-invalid-message"));
			return;
		}
	}
	
	public void onSuccessFromFilter() {
		LOG.debug("ON SUX");
		this.conferences = this.dataStore.getConferences(this.filterDate, this.tags);
	}

	public List<Conference> getConferences() {
		return conferences;
	}
}
