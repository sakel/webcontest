package org.zabica.webcontest.springmvc.beans;

import java.io.Serializable;

import org.zabica.webcontest.common.user.User;

public class UserSession implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5456015522513267646L;
	
	private boolean loggedIn = false;
	private User user;
	
	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
