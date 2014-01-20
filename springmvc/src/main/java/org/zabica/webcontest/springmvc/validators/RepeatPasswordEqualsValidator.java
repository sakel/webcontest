package org.zabica.webcontest.springmvc.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RepeatPasswordEqualsValidator implements ConstraintValidator<RepeatPasswordEquals, PasswordInput> {
	
	@Override
	public void initialize(RepeatPasswordEquals constraintAnnotation) {
	}

	@Override
	public boolean isValid(PasswordInput value, ConstraintValidatorContext context) {
		if(!value.getPassword().equals(value.getRepeatPassword()))
			return false;
		return true;
	}

	
}
