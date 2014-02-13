package org.zabica.webcontest.stripes.beans;

import org.zabica.webcontest.common.user.User;

public class UserRegistration extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1017480765994806013L;
	
	private String repeatPassword;

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
}
