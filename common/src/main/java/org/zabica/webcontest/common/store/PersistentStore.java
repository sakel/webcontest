package org.zabica.webcontest.common.store;

import org.hypergraphdb.HGHandle;
import org.hypergraphdb.HGQuery.hg;
import org.hypergraphdb.HyperGraph;
import org.hypergraphdb.indexing.ByPartIndexer;
import org.zabica.webcontest.common.user.User;

public class PersistentStore {

	private String storeFile;
	private HyperGraph graph;

	public PersistentStore() {
	}

	public PersistentStore(String storeFile) {
		this.setStoreFile(storeFile);
		init();
	}

	public void init() {
		if (this.graph == null) {
			this.graph = new HyperGraph(this.storeFile);

			HGHandle bTypeH = graph.getTypeSystem().getTypeHandle(User.class);
			graph.getIndexManager().register(
					new ByPartIndexer<>(bTypeH, "email"));
			graph.runMaintenance();
		}
	}

	public String getStoreFile() {
		return storeFile;
	}

	public void setStoreFile(String storeFile) {
		this.storeFile = storeFile;
	}

	public User getUser(String email) {
		return hg.getOne(this.graph, hg.eq("email", email));
	}

	public void addUser(User newUser) {
		User u = hg.getOne(this.graph, hg.eq("email", newUser.getEmail()));
		if (u != null) {
			this.graph.add(newUser);
		}
	}
}
