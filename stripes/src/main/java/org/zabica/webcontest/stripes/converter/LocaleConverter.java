package org.zabica.webcontest.stripes.converter;

import java.util.Collection;
import java.util.Locale;

import net.sourceforge.stripes.validation.TypeConverter;
import net.sourceforge.stripes.validation.ValidationError;


public class LocaleConverter implements TypeConverter<Locale>{

	@Override
	public void setLocale(Locale locale) {
	}

	@Override
	public Locale convert(String input, Class<? extends Locale> targetType,
			Collection<ValidationError> errors) {
		String[] locarr = input.split("[_]");
		Locale loc = new Locale(locarr[0], locarr[1]);
		return loc;
	}
	
}
