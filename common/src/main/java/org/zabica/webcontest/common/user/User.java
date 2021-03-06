package org.zabica.webcontest.common.user;

import java.io.Serializable;
import java.util.Locale;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9029942778828926065L;

	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private Locale locale = Locale.US;
	
	public User() {
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public boolean isPasswordValid(String password) {
		return this.password.equals(password);
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return getEmail()+":"
					+password;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
}
