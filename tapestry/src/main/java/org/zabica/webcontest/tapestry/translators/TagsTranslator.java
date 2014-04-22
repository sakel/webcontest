package org.zabica.webcontest.tapestry.translators;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.Field;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.Translator;
import org.apache.tapestry5.ValidationException;
import org.apache.tapestry5.services.FormSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TagsTranslator implements Translator<String[]> {
	
	private static Logger LOG = LoggerFactory.getLogger(TagsTranslator.class);
	
	private String name;
	private Class<String[]> type;
	private String messageKey = "tags-wrong-format";
	
	public TagsTranslator(String name) {
		this.name = name;
		this.type = String[].class; 
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String toClient(String[] value) {
		StringBuffer sb = new StringBuffer();
		int count = 1;
		for(String s : value) {
			sb.append(s);
			if(count < value.length) {
				sb.append(",");
			}
			count++;
		}
		LOG.debug("The value is \"{}\"", sb.toString());
		return sb.toString();
	}

	@Override
	public Class<String[]> getType() {
		return this.type;
	}

	@Override
	public String getMessageKey() {
		return this.messageKey;
	}

	@Override
	public String[] parseClient(Field field, String clientValue,
			String message) throws ValidationException {
		String[] tags = clientValue.split(",");
		List<String> tagList = new ArrayList<String>();
		for(String tag : tags) {
			tag = tag.trim();
			if(tag.isEmpty())
				continue;
			tagList.add(tag);
			LOG.debug("Added tag: " + tag);
		}
		return tagList.toArray(new String[0]);
	}

	@Override
	public void render(Field field, String message, MarkupWriter writer,
			FormSupport formSupport) {
	}

}
