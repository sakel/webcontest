package org.zabica.webcontest.tapestry.pages;

import org.apache.tapestry5.annotations.ActivationRequestParameter;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zabica.webcontest.common.venue.Conference;

public class ConferenceId extends BasePage {

	private static Logger LOG = LoggerFactory.getLogger(ConferenceId.class);
	
	@ActivationRequestParameter
	private String confId;
	
	@Persist
	private Conference conference;
	
	@Property
	private String tag;
	
	public Object onActivate(String confId) {
		this.confId = confId;
		LOG.debug("Preparing data for: " + this.confId);
		
		this.conference = this.dataStore.getConference(this.confId);
		if(this.conference == null) {
			return Conferences.class;
		}
		
		return null;
	}
	
	public Conference getConference() {
		return this.conference;
	}
}
