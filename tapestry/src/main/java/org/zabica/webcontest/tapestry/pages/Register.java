package org.zabica.webcontest.tapestry.pages;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.PasswordField;
import org.apache.tapestry5.corelib.components.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zabica.webcontest.common.user.User;

public class Register extends BasePage {

	private static Logger LOG = LoggerFactory.getLogger(Register.class);
	
	@Property
	private String name;
	
	@Property
	private String surname;
	
	@Property
	private String email;
	
	@InjectComponent
	private TextField emailField;
	
	@Property
	private String password;
	
	@Property
	private String repeatPassword;
	
	@InjectComponent
	private PasswordField repeatPasswordField;

	@Component
	private Form register;
	
	public void onActivate() {
		LOG.debug("Activating Register");
	}
	
	public void onValidateFromRegister() {
		LOG.debug("EVT: On validate");
		if(!this.password.equals(this.repeatPassword)) {
			register.recordError(repeatPasswordField, componentResources.getMessages().get("repeatPasswordField-donotmatch-message"));
			return;
		}
		
		User u = this.dataStore.getUser(this.email);
		if(u != null) {
			register.recordError(emailField, componentResources.getMessages().get("emailField-exists-message"));
			return;
		}
	}
	
	public Object onSuccessFromRegister() {
		LOG.debug("EVT: On success");
		
		LOG.debug("Validation passed successfully");
		User u = new User();
		u.setEmail(this.email);
		u.setFirstName(this.name);
		u.setLastName(this.surname);
		u.setPassword(this.password);
		
		if(!this.dataStore.addUser(u)) {
			LOG.error("Could not add user to DB");
			return null;
		}
		
		return Login.class;
	}

}
