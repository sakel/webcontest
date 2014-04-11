package org.zabica.webcontest.tapestry.services;

import java.util.List;

import org.zabica.webcontest.tapestry.dto.LocaleChoiceDescriptor;

public interface LocaleManager {
	public List<LocaleChoiceDescriptor> getLocaleChoices();
}
