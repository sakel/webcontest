package org.zabica.webcontest.springmvc.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RepeatPasswordEqualsValidator.class)
@Documented
public @interface RepeatPasswordEquals {
	String message() default "{org.zabica.webcontest.springmvc.validators.RepeatPasswordEquals.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
