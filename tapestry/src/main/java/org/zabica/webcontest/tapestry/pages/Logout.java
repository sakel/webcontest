package org.zabica.webcontest.tapestry.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logout extends BasePage {
	
	private static Logger LOG = LoggerFactory.getLogger(Logout.class);
	
	public Object onActivate() {
		LOG.debug("ACT: On action");
		
		this.user = null;
		return Login.class;
	}
}
