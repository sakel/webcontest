package org.zabica.webcontest.tapestry.translators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.tapestry5.Field;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.ValidationException;
import org.apache.tapestry5.internal.translator.AbstractTranslator;
import org.apache.tapestry5.services.FormSupport;

public class StringListTranslator extends AbstractTranslator<List<String>> {

	@SuppressWarnings("unchecked")
	public StringListTranslator() {
		super("stringlist", (Class<List<String>>) new ArrayList<String>().getClass(), "stringlist");
	}

	@Override
	public List<String> parseClient(Field field, String val, String msg)
			throws ValidationException {
		return (List<String>) Arrays.asList(val.split(","));
	}

	@Override
	public void render(Field arg0, String arg1, MarkupWriter arg2,
			FormSupport arg3) {
	}

	@Override
	public String toClient(List<String> slist) {
		return StringUtils.join(slist, ",");
	}

}
