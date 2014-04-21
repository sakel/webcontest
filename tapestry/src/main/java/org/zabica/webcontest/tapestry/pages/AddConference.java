package org.zabica.webcontest.tapestry.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zabica.webcontest.common.venue.Conference;

public class AddConference extends BasePage {

	private static Logger LOG = LoggerFactory.getLogger(AddConference.class);
	
	@Property
	private String title;
	
	@InjectComponent
	private TextField titleField; 
	
	@Property
	private String desc;
	
	@Property
	private String start;
	
	@InjectComponent
	private TextField startField;
	
	@Property
	private Integer duration;
	
	@Property
	private String regdeadline;
	
	@InjectComponent
	private TextField regdeadlineField;
	
	@Property
	private Integer maxattendees;
	
	@Property
	private Double fee;
	
	@Property
	private String location;
	
	@Property
	private List<String> tags;
	
	private Date startDate;
	private Date regDate;
	
	@Component
    private Form addconf;
	
	public void onValidateFromAddconf() {
		String df = componentResources.getMessages().get("date.format");
		
		SimpleDateFormat sdf = new SimpleDateFormat(df);
		try {
			this.startDate = sdf.parse(this.start);
		} catch (ParseException e) {
			addconf.recordError(startField, componentResources.getMessages().get("startField-invalid-message"));
			return;
		}
		
		try {
			this.regDate = sdf.parse(this.regdeadline);
		} catch (ParseException e) {
			addconf.recordError(regdeadlineField, componentResources.getMessages().get("regdeadlineField-invalid-message"));
			return;
		}
		
		if(regDate.after(startDate)) {
			addconf.recordError(regdeadlineField, componentResources.getMessages().get("regdeadlineField-after-message"));
			return;
		}
	}
	
	public Object onSuccessFromAddconf() {
		Conference conf = new Conference();
		conf.setDescription(this.desc);
		conf.setDuration(this.duration);
		conf.setFee(this.fee);
		conf.setLocation(this.location);
		conf.setMaxAttendees(this.maxattendees);
		conf.setRegistrationDeadline(this.regDate);
		conf.setStart(this.startDate);
		conf.setTags(tags);
		conf.setTitle(this.title);
		
		this.dataStore.addConference(conf);
		
		
		return Conferences.class;
	}
	
}
