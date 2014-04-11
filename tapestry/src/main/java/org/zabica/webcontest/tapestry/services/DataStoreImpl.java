package org.zabica.webcontest.tapestry.services;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.PostInjection;
import org.apache.tapestry5.ioc.annotations.Value;
import org.apache.tapestry5.ioc.services.RegistryShutdownHub;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zabica.webcontest.common.store.PersistentStore;

public class DataStoreImpl extends PersistentStore implements DataStore {

	private static Logger LOG = LoggerFactory.getLogger(DataStoreImpl.class);
	
	@Inject
	@Value("${storefile}")
	private String sFile;
	
	public DataStoreImpl() {
		super();
	}
	
	@Override
	@PostInjection
	public void init(RegistryShutdownHub shutdownHub) {
		
		setStoreFile(sFile);
		
		LOG.debug("Initializing with file name {}", getStoreFile());
		
		super.init();
				
		shutdownHub.addRegistryShutdownListener(new Runnable() {
			
			@Override
			public void run() {
				deinit();
			}
		});
	}
	
}
