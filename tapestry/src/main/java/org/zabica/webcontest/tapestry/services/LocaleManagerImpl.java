package org.zabica.webcontest.tapestry.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.tapestry5.ioc.annotations.PostInjection;
import org.apache.tapestry5.ioc.internal.util.ClasspathResource;
import org.apache.tapestry5.ioc.services.SymbolSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zabica.webcontest.tapestry.dto.LocaleChoiceDescriptor;

public class LocaleManagerImpl implements LocaleManager {

	private static Logger LOG = LoggerFactory.getLogger(LocaleManagerImpl.class);
	
	@Inject
	private SymbolSource symbolSource;
	
	@Inject
	private ContextAssetResolver assetResolver;
	
	private Map<String, LocaleChoiceDescriptor> localeDescriptors; 
	
	@PostInjection
	public void init() {
		this.localeDescriptors = new HashMap<String, LocaleChoiceDescriptor>();
		String symbol = symbolSource.expandSymbols("${app.locales}");
		
		
		String[] locales = symbol.split(",");
		for(String localeChoice : locales) {
			
			LocaleChoiceDescriptor lcd = new LocaleChoiceDescriptor(this.symbolSource.expandSymbols("${" + localeChoice + ".locale}"), this.symbolSource.expandSymbols("${" + localeChoice + ".language}"), this.assetResolver.getAsset(new ClasspathResource(this.symbolSource.expandSymbols("${" + localeChoice + ".image}"))));
			LOG.debug("Created LocaleChoice: " + lcd.toString());
			
			this.localeDescriptors.put(localeChoice, lcd);
		}
	}

	@Override
	public List<LocaleChoiceDescriptor> getLocaleChoices() {
		return new ArrayList<LocaleChoiceDescriptor>(this.localeDescriptors.values());
	}
}
