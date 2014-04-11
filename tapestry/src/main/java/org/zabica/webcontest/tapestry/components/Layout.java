package org.zabica.webcontest.tapestry.components;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.services.RequestGlobals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zabica.webcontest.tapestry.dto.LocaleChoiceDescriptor;
import org.zabica.webcontest.tapestry.pages.BasePage;
import org.zabica.webcontest.tapestry.services.LocaleManager;

/**
 * Layout component for pages of application tapestry.
 */
@Import(stylesheet = {"context:layout/layout.css"})
public class Layout extends BasePage
{
	private static Logger LOG = LoggerFactory.getLogger(Layout.class);
	
    /**
     * The page title, for the <title> element and the <h1> element.
     */
    @Property
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    private String title;
    
    @Property
    private String pageName;
    
    @Property
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private String sidebarTitle;

    @Property
    @Parameter(defaultPrefix = BindingConstants.LITERAL)
    private Block sidebar;

    @Property
    @Inject
    @Symbol(SymbolConstants.APPLICATION_VERSION)
    private String appVersion;
    
    @Inject
    private LocaleManager localeManager;
    
    @Property
    private LocaleChoiceDescriptor _localeChoice;
    
    @Inject
    private RequestGlobals requestGlobals;
    
    public List<LocaleChoiceDescriptor> getLocaleChoices() {
    	LOG.debug("Getting locale choices");
    	StringBuffer url = this.requestGlobals.getHTTPServletRequest().getRequestURL();
    	String qs = this.requestGlobals.getHTTPServletRequest().getQueryString();
    	LOG.debug("Query string: " + qs);
    	if(qs != null) {
    		url.append("?" + qs);
    	}
    	
    	List<LocaleChoiceDescriptor> locales = this.localeManager.getLocaleChoices();
    	for(LocaleChoiceDescriptor lcd : locales) {
    		Map<String, String> params = new HashMap<String, String>();
    		params.put("locale", lcd.getLocale());
    		params.put("callback", url.toString());
    		lcd.setParams(params);
    	}
    	return locales;
    }
    
    public String getCurrentPage() {
    	return this.componentResources.getPageName();
    }
    
    public String getClassForPageName()
    {
        return componentResources.getPageName().equalsIgnoreCase(pageName)
                ? "current_page_item"
                : null;
    }

    public String[] getPageNames()
    {
        return new String[]{"Index", "About", "Contact", "Login", "Logout", "Register", "Conferences"};
    }
}
