package org.zabica.webcontest.common.user;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9029942778828926065L;

	private String email;
	private String firstName;
	private String lastName;
	private Password password;
	
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
		return this.password.isValid(password);
	}
	public void setPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		this.password = Password.encryptPassword(password);
	}
}
