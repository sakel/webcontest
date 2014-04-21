package org.zabica.webcontest.tapestry.pages;

import org.apache.tapestry5.annotations.Property;
import org.zabica.webcontest.common.user.User;

import java.util.List;

public class Users extends BasePage {

	@Property
	private User _person;
	
	public List<User> getAllUsers() {
		return this.dataStore.getAllUsers();
	}
	
}
