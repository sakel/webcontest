package org.zabica.webcontest.springmvc.validators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

public class TagConverter implements Converter<String, List<String>> {

	@Override
	public List<String> convert(String tags) {
		List<String> sl = new ArrayList<String>();
		if(!tags.isEmpty()) {
			sl = Arrays.asList(tags.split("[,]"));
		}
		return sl;
	}	
}
