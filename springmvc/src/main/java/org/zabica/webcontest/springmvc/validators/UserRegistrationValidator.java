package org.zabica.webcontest.springmvc.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.zabica.webcontest.springmvc.beans.UserRegistration;

public class UserRegistrationValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserRegistration.class.equals(clazz);
	}

	@Override
	public void validate(Object input, Errors errors) {
		System.out.println("Wooooot: " + input.getClass().getSimpleName());
		if(!(input instanceof UserRegistration)) {
		}
		UserRegistration ur = (UserRegistration) input;
		if(!ur.getPassword().equals(ur.getRepeatPassword())) {
			
		}
	}

}
