package org.zabica.webcontest.tapestry.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zabica.webcontest.common.venue.Conference;

public class Conferences extends BasePage {
	
	private static Logger LOG = LoggerFactory.getLogger(Conferences.class);
	
	@Property
	private String[] tags;
	
	@Property
	private String date;

	@InjectComponent
	private TextField dateField;
	
	@Persist
	private List<Conference> conferences;
	
	@Property
	private Conference _conference;

	@Component
	private Form filter;
	
	@Persist
	private Date filterDate;
	
	public Date getFilterDate() {
		return filterDate;
	}

	public void setFilterDate(Date filterDate) {
		this.filterDate = filterDate;
	}

	public void onValidateFromFilter() {
		if(this.date == null) {
			this.filterDate = null;
			return;
		}
		
		String df = componentResources.getMessages().get("date.format");
		SimpleDateFormat sdf = new SimpleDateFormat(df);
		
		LOG.debug("Date: " + this.date + " format " + df);
		
		try {
			this.filterDate = sdf.parse(this.date);
			LOG.debug("Parsed: " + filterDate);	
		} catch (ParseException e) {
			filter.recordError(dateField, componentResources.getMessages().get("dateField-invalid-message"));
			return;
		}
	}

	public void onSuccessFromFilter() {
		LOG.debug("Setting date: " + this.filterDate + " for date " + this.date);
		this.conferences = this.dataStore.getConferences(this.filterDate, this.tags != null ? Arrays.asList(this.tags) : null);
		LOG.debug("Found: " + this.conferences.size() + " conferences");
	}
	
	public void onPrepareForRender() {
		if(this.conferences == null)
			this.conferences = this.dataStore.getConferences(null, null);
	}
	
	public List<Conference> getConferences() {
		return conferences;
	}

	public String getRowClass() {
		return "conferences mouseover";
	}
}
