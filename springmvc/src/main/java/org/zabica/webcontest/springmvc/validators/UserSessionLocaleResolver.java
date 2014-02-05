package org.zabica.webcontest.springmvc.validators;

import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.TimeZoneAwareLocaleContext;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.util.WebUtils;
import org.zabica.webcontest.common.user.User;
import org.zabica.webcontest.springmvc.beans.UserSession;

public class UserSessionLocaleResolver extends SessionLocaleResolver {

	@Autowired
	private UserSession userSession;
	
	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		System.out.println("Request locale: " + request.getLocale().toString());
		Locale locale = null;
		User u = this.userSession.getUser();
		if(u != null) {
			locale = u.getLocale();
			System.out.println("Session locale: " + locale.toString());
		}
		
		if (locale == null) {
			locale = determineDefaultLocale(request);
		}
		return locale;
	}

	@Override
	public LocaleContext resolveLocaleContext(final HttpServletRequest request) {
		return new TimeZoneAwareLocaleContext() {
			@Override
			public Locale getLocale() {
				Locale locale = null;
				User u = userSession.getUser();
				if(u != null) {
					locale = u.getLocale();
				}
				if (locale == null) {
					locale = determineDefaultLocale(request);
				}
				return locale;
			}
			@Override
			public TimeZone getTimeZone() {
				TimeZone timeZone = (TimeZone) WebUtils.getSessionAttribute(request, TIME_ZONE_SESSION_ATTRIBUTE_NAME);
				if (timeZone == null) {
					timeZone = determineDefaultTimeZone(request);
				}
				return timeZone;
			}
		};
	}
	
	public UserSession getUserSession() {
		return userSession;
	}

	public void setUserSession(UserSession userSession) {
		this.userSession = userSession;
	}
}
