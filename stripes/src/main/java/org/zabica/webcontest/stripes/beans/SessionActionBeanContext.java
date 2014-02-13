package org.zabica.webcontest.stripes.beans;

import org.zabica.webcontest.common.user.User;

import net.sourceforge.stripes.action.ActionBeanContext;

public class SessionActionBeanContext extends ActionBeanContext {
	
	public User getUser() {
		return (User) getRequest().getSession(true).getAttribute("user");
	}
	
	public void setUser(User u) {
		getRequest().getSession(true).setAttribute("user", u);
	}
	
}
