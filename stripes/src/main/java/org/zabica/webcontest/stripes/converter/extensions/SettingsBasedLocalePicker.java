package org.zabica.webcontest.stripes.converter.extensions;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.zabica.webcontest.common.user.User;

import net.sourceforge.stripes.config.Configuration;
import net.sourceforge.stripes.localization.LocalePicker;

public class SettingsBasedLocalePicker implements LocalePicker {

	private String encoding = "UTF-8";
	
	@Override
	public void init(Configuration configuration) throws Exception {
		String enc = configuration.getBootstrapPropertyResolver().getProperty("LocalePicker.Encoding");
		if(enc != null && !enc.isEmpty()) {
			this.encoding = enc;
		}
	}

	@Override
	public Locale pickLocale(HttpServletRequest request) {
		User u = (User) request.getSession(true).getAttribute("user");
		if(u == null) {
			return request.getLocale();
		}
		return u.getLocale();
	}

	@Override
	public String pickCharacterEncoding(HttpServletRequest request,
			Locale locale) {
		return this.encoding;
	}

}
