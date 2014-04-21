package org.zabica.webcontest.tapestry.pages;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.lang3.LocaleUtils;
import org.apache.tapestry5.annotations.ActivationRequestParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Language extends BasePage {
	
	private static Logger LOG = LoggerFactory.getLogger(Language.class);
	
	@ActivationRequestParameter
	private String locale;
	
	@ActivationRequestParameter
	private String callback;
	
	public Object onActivate() {
		LOG.debug("On activate: " + locale + " ::: " + callback);
		
		this.user.setLocale(LocaleUtils.toLocale(locale));
		this.dataStore.updateUser(this.user);
		
		try {
			return new URL(this.callback);
		} catch (MalformedURLException e) {
			LOG.error("The requested URL is malformed");
			return "login";
		}
	}
}
