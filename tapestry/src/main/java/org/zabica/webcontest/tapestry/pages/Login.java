package org.zabica.webcontest.tapestry.pages;


import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.PasswordField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zabica.webcontest.common.user.User;

public class Login extends BasePage {

	private static Logger LOG = LoggerFactory.getLogger(Login.class);
		
	@Property
	private String email;
	
	@Property
	private String password;

	@Component
    private Form login;
	
    @InjectComponent
    private PasswordField passwordField;
    
	public void onActivate() {
		LOG.warn("Datastore: " + this.dataStore.getStoreFile());
	}
	
	public void onValidateFromLogin() {
		User user = this.dataStore.getUser(this.email);
		if(user == null) {
			login.recordError(passwordField, componentResources.getMessages().get("login.username.invalid"));
			return;
		}
		
		if(!user.isPasswordValid(this.password)) {
			login.recordError(passwordField, componentResources.getMessages().get("login.username.invalid"));
			return;
		}
		
		this.user = user;
	}
	
	public Object onSuccessFromLogin() {
		
		return Login.class;
	}
}
