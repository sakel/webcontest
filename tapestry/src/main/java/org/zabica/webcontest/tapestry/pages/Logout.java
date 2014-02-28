package org.zabica.webcontest.tapestry.pages;

public class Logout {
	public Object onAction() {
		//TODO: Remove user's session token
		
		return Login.class;
	}
}
