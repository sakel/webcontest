package org.zabica.webcontest.tapestry.services;

import java.util.Date;
import java.util.List;

import org.apache.tapestry5.ioc.services.RegistryShutdownHub;
import org.zabica.webcontest.common.user.User;
import org.zabica.webcontest.common.venue.Conference;

public interface DataStore {

	public void init();
	public void init(RegistryShutdownHub shutdownHub);
	
	public void deinit();

	public String getStoreFile();

	public void setStoreFile(String storeFile);

	public User getUser(String email);

	public boolean addUser(User newUser);

	public boolean updateUser(User user);

	public boolean removeUser(String email);

	public List<User> getAllUsers();

	public List<Conference> getConferences(Date date, List<String> tags);

	public boolean addConference(Conference conf);

	public Conference getConference(String uuid);

	public void remConference(String uuid);

}