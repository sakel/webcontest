package org.zabica.webcontest.tapestry.services;

import org.apache.tapestry5.Asset;
import org.apache.tapestry5.ioc.Resource;

public interface ContextAssetResolver {

	public Asset getAsset(Resource resource);

}
