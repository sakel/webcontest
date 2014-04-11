package org.zabica.webcontest.tapestry.services;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.internal.services.ContextAssetFactory;
import org.apache.tapestry5.ioc.Resource;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.PostInjection;
import org.apache.tapestry5.services.AssetPathConverter;
import org.apache.tapestry5.services.Context;
import org.apache.tapestry5.services.assets.AssetPathConstructor;

public class ContextAssetResolverImpl implements ContextAssetResolver {

    @Inject
    private AssetPathConstructor pathConstructor;
    
    @Inject
    private AssetPathConverter pathConverter;
    
    @Inject
    private Context context;
    
    private ContextAssetFactory caf; 
    
    @PostInjection
    public void init() {
    	this.caf = new ContextAssetFactory(this.pathConstructor, this.context, this.pathConverter);
    }
    
    @Override
	public Asset getAsset(Resource resource) {
    	return caf.createAsset(resource);
    }
	
}
