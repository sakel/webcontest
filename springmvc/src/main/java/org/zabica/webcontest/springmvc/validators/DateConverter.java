package org.zabica.webcontest.springmvc.validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.convert.converter.Converter;
import org.zabica.webcontest.springmvc.beans.UserSession;

public class DateConverter implements Converter<String, Date> {

	@Autowired
	private UserSession userSession;
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	public Date convert(String date) {
		System.out.println(getClass().getSimpleName() + "-" + userSession.isLoggedIn());
		Locale locale = Locale.getDefault();
		if(this.userSession.getUser() != null) {
			locale = this.userSession.getUser().getLocale();
		}
		String format = this.messageSource.getMessage("date.format", new Object[] {}, locale);
		System.out.println("df=" + format);
		
		SimpleDateFormat df = new SimpleDateFormat(format);
		
		Date parsed;
		try {
			parsed = df.parse(date);
		} catch (ParseException e) {
			System.out.println("Exception: df=" + this.messageSource.getMessage("date.format", new Object[] {}, locale));
			throw new IllegalArgumentException("Exception: df=" + this.messageSource.getMessage("date.format", new Object[] {}, locale), e);
		}
		
		return parsed;
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
