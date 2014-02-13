package org.zabica.webcontest.stripes.converter;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import net.sourceforge.stripes.validation.TypeConverter;
import net.sourceforge.stripes.validation.ValidationError;

public class TagConverter implements TypeConverter<List<String>> {

	@Override
	public void setLocale(Locale locale) {
	}

	@Override
	public List<String> convert(String input,
			Class<? extends List<String>> targetType,
			Collection<ValidationError> errors) {
		return Arrays.asList(input.split("[,]"));
	}

}
