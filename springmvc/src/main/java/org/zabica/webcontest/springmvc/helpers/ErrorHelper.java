package org.zabica.webcontest.springmvc.helpers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class ErrorHelper {
	public static Map<String, String> getErrorMap(BindingResult result) {
		HashMap<String, String> errors = new HashMap<String, String>(); 
		for(ObjectError err : result.getAllErrors()) {
			if(err instanceof FieldError) {
				errors.put(((FieldError) err).getField(), err.getDefaultMessage());
			} else if(err instanceof ObjectError) {
				errors.put(err.getObjectName(), err.getDefaultMessage());
			}
		}
		return errors;
	}
}
