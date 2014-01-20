package org.zabica.webcontest.springmvc.beans;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.zabica.webcontest.springmvc.validators.PasswordInput;
import org.zabica.webcontest.springmvc.validators.RepeatPasswordEquals;

@RepeatPasswordEquals
public class UserRegistration implements PasswordInput {

	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String surname;
	
	@NotNull
	@Pattern(regexp=EMAIL_PATTERN)
	private String email;
	
	@NotBlank()
	private String password;
	
	@NotBlank(message="{repeatPassword}")
	private String repeatPassword;
	
	public UserRegistration() {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String getRepeatPassword() {
		return repeatPassword;
	}
	public void setRepeatPassword(String passwordagain) {
		this.repeatPassword = passwordagain;
	}
}
