package org.zabica.webcontest.tapestry.dto;

import java.io.Serializable;
import java.util.Map;

import org.apache.tapestry5.Asset;

public class LocaleChoiceDescriptor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3063875888320280447L;

	private String locale;
	private String language;
	private Asset flagAsset;
	private Map<String, String> params;
	
	public LocaleChoiceDescriptor() {
	}
	
	public LocaleChoiceDescriptor(String locale) {
		this.setLocale(locale);
	}

	public LocaleChoiceDescriptor(String locale, String language, Asset flagAsset) {
		this.setLocale(locale);
		this.setLanguage(language);
		this.setFlagAsset(flagAsset);
	}
	
	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public Asset getFlagAsset() {
		return flagAsset;
	}

	public void setFlagAsset(Asset flagAsset) {
		this.flagAsset = flagAsset;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	@Override
	public String toString() {
		return this.locale + " - " + this.language + " - " + this.flagAsset.toClientURL();
	}

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}
}
