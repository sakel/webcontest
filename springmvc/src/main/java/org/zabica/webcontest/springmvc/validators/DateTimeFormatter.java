package org.zabica.webcontest.springmvc.validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.format.Formatter;
import org.zabica.webcontest.springmvc.beans.UserSession;

public class DateTimeFormatter implements Formatter<Date> {

	@Autowired
	private UserSession userSession;
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	public String print(Date object, Locale locale) {
		if(userSession != null || userSession.getUser() != null)
			locale = userSession.getUser().getLocale();
		
		String format = this.messageSource.getMessage("date.format", new Object[] {}, locale);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		
		return sdf.format(object);
	}

	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		if(userSession != null || userSession.getUser() != null)
			locale = userSession.getUser().getLocale();
		
		String format = this.messageSource.getMessage("date.format", new Object[] {}, locale);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		
		return sdf.parse(text);
	}

	public UserSession getUserSession() {
		return userSession;
	}

	public void setUserSession(UserSession userSession) {
		this.userSession = userSession;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

}
