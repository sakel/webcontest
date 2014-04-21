package org.zabica.webcontest.tapestry.pages;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.SessionAttribute;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Context;
import org.apache.tapestry5.services.ContextValueEncoder;
import org.apache.tapestry5.services.LocalizationSetter;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.apache.tapestry5.services.TranslatorSource;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zabica.webcontest.common.user.User;
import org.zabica.webcontest.tapestry.services.ContextAssetResolver;
import org.zabica.webcontest.tapestry.services.DataStore;

public abstract class BasePage {
	
	private static Logger LOG = LoggerFactory.getLogger(BasePage.class);
	
	@Inject
	protected DataStore dataStore;
	
    @Inject
    protected ComponentResources componentResources;
    
    @Inject
    protected TranslatorSource translatorSource;
    
    @Inject
    protected ContextValueEncoder valueEncoder;
    
    @Environmental
    protected JavaScriptSupport javaScriptSupport;
    
    @Inject
    protected Context context;
    
    @Inject
    protected ContextAssetResolver assetResolver;
    
    @SessionAttribute
    protected User user;

    @Inject
    protected PageRenderLinkSource linkSource;
    
    @Inject
    protected LocalizationSetter localizationSetter;
    
    public User getUser() {
    	LOG.debug("BASE: User is null? " + (this.user == null ? "true" : this.user.getEmail()));
    	return this.user;
    }
}
