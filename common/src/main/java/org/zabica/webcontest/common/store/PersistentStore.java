package org.zabica.webcontest.common.store;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hypergraphdb.HGHandle;
import org.hypergraphdb.HGQuery.hg;
import org.hypergraphdb.HyperGraph;
import org.hypergraphdb.indexing.ByPartIndexer;
import org.zabica.webcontest.common.user.User;
import org.zabica.webcontest.common.venue.Conference;

public class PersistentStore {

	private String storeFile;
	private HyperGraph graph = null;

	public PersistentStore() {
	}

	public PersistentStore(String storeFile) {
		this.setStoreFile(storeFile);
		init();
	}

	public void init() {
		System.out.println("Store file: " + this.storeFile);
		
		if (this.graph == null) {
			this.graph = new HyperGraph(this.storeFile);

			HGHandle userTypeH = graph.getTypeSystem().getTypeHandle(User.class);
			graph.getIndexManager().register(
					new ByPartIndexer<>(userTypeH, "email"));
			
			HGHandle confTypeH = graph.getTypeSystem().getTypeHandle(Conference.class);
//			graph.getIndexManager().register(
//					new ByPartIndexer<>(confTypeH, "start"));
//			graph.getIndexManager().register(
//					new ByPartIndexer<>(confTypeH, "location"));
//			graph.runMaintenance();
		}
	}

	public void deinit() {
		this.graph.close();
	}

	public String getStoreFile() {
		return storeFile;
	}

	public void setStoreFile(String storeFile) {
		this.storeFile = storeFile;
	}

	public User getUser(String email) {
		
		return this.graph.getOne(hg.and(hg.type(User.class), hg.eq("email", email)));
	}

	public boolean addUser(User newUser) {
		User u = getUser(newUser.getEmail());
		if (u == null) {	
			this.graph.add(newUser);
			return true;
		}
		System.out.println("User: " + u.getEmail() + " exists already");
		return false;
	}
	
	public boolean updateUser(User user) {
		User u = getUser(user.getEmail());

		u.setLocale(user.getLocale());
		
		return this.graph.update(u);
	}

	public boolean removeUser(String email) {
		User u = getUser(email);
		HGHandle handle = this.graph.getHandle(u);
		if(u != null) {
			return this.graph.remove(handle);
		}
		return false;
	}

	public List<User> getAllUsers() {
		return this.graph.getAll(hg.typePlus(User.class));
	}

	public List<Conference> getConferences(Date date, List<String> tags) {
		List<Conference> selected_confs = new ArrayList<>();
		if(date == null)
			date = new Date();
		List<Conference> confs = this.graph.getAll(hg.and(hg.type(Conference.class), hg.gt("start", date)));
		if(tags == null || tags.isEmpty()) {
			return confs;
		}
		
		for(Conference c : confs) {
			List<String> ts = c.getTags();
			
			if(ts == null) 
				continue;
			
			for(String tag : tags) {
				if(ts.contains(tag)) {
					selected_confs.add(c);
					break;
				}
			}
		}
		
		return selected_confs;
	}

	public boolean addConference(Conference conf) {
		this.graph.add(conf);
		
		return true;
	}

	public Conference getConference(String uuid) {
		Conference conf = this.graph.getOne(hg.and(hg.type(Conference.class), hg.eq("id", uuid)));
		return conf;
	}

	public void remConference(String uuid) {
		Conference conf = this.graph.getOne(hg.and(hg.type(Conference.class), hg.eq("id", uuid)));
		HGHandle handle = this.graph.getHandle(conf);
		this.graph.remove(handle);
	}
}
