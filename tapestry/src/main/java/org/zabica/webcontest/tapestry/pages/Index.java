package org.zabica.webcontest.tapestry.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Start page of application tapestry.
 */
public class Index
{

	private static Logger LOG = LoggerFactory.getLogger(Index.class);
	
	public Object onActivate() {
		LOG.debug("On action");
		return Login.class;
	}
}
