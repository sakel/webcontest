package org.zabica.webcontest.springmvc.beans;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.zabica.webcontest.springmvc.validators.PasswordInput;
import org.zabica.webcontest.springmvc.validators.RepeatPasswordEquals;

@RepeatPasswordEquals(message="{rpassword.invalid}")
public class UserRegistration implements PasswordInput {

	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	@NotBlank(message="{name.blank}")
	private String name;
	
	@NotBlank(message="{surname.blank}")
	private String surname;
	
	@Size(min=5, max=40,message="{email.length}")
	@Pattern(regexp=EMAIL_PATTERN, message="{email.invalid}")
	private String email;
	
	@Size(min=4, max=20, message="{password.length}")
	@NotBlank(message="{password.blank}")
	private String password;
	
	@Size(min=4, max=20, message="{password.length}")
	@NotBlank(message="{password.blank}")
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
