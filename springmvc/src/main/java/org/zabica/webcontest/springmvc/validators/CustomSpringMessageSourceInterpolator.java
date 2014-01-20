package org.zabica.webcontest.springmvc.validators;

import java.util.Locale;

import javax.validation.MessageInterpolator;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.NoSuchMessageException;

public class CustomSpringMessageSourceInterpolator extends ResourceBundleMessageInterpolator implements MessageInterpolator, MessageSourceAware, InitializingBean {

	private MessageSource messageSource;

	@Override
	public String interpolate(String messageTemplate, Context context) {
		try {
			return resolveMessage(messageTemplate, context, Locale.getDefault());
		} catch (NoSuchMessageException e) {
			System.out.println("Nope...");
			return super.interpolate(messageTemplate, context);
		}
	}

	@Override
	public String interpolate(String messageTemplate, Context context, Locale locale) {
		try {
			return resolveMessage(messageTemplate, context, Locale.getDefault());
		} catch (NoSuchMessageException e) {
			System.out.println("Nope...");
			return super.interpolate(messageTemplate, context, locale);
		}
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public void afterPropertiesSet() throws Exception {
		if (messageSource == null) {
			throw new IllegalStateException("MessageSource was not injected, could not initialize " + this.getClass().getSimpleName());
		}
	}

	private static String removeFirstAndLast(String string) {
		return string.substring(1, string.length() - 1);
	}

	private String resolveMessage(String messageTemplate, Context context, Locale locale) throws NoSuchMessageException {

		String classname = null;
		for(Class c : context.getConstraintDescriptor().getConstraintValidatorClasses()) {
			classname = c.getSimpleName().replace("Validator", "");
			break;
		}
		
		String message = messageTemplate;		
		try {
			message = this.messageSource.getMessage(removeFirstAndLast(messageTemplate), new Object[] {}, locale);
		}catch(NoSuchMessageException e) {
			try {
				message = this.messageSource.getMessage(classname + "." + removeFirstAndLast(messageTemplate), new Object[] {}, locale);
			}catch(NoSuchMessageException e1) {
				message = this.messageSource.getMessage(classname, new Object[] {}, locale);
			}
		}
		
		return message;
	}
	
}
