package org.zabica.webcontest.common.user;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.zabica.webcontest.common.store.PersistentStore;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PersistentStoreTest {

	private PersistentStore store;
	
	public void init() {
		System.out.println("INIT");
		store = new PersistentStore("/tmp/hgdb_test1");
	}
	
	@Test
	public void a_add() {
		init();
		System.out.println("ADD");
		store.init();
		User u = new User();
		u.setEmail("Bla");
		u.setFirstName("bla");
		u.setLastName("Ble");
		u.setPassword("gunigugu");

		Assert.assertTrue(store.addUser(u));
		store.deinit();
	}
	
	@Test
	public void a_get() {
		System.out.println("Get");
		init();
		store.init();
		Assert.assertNotNull(store.getUser("Bla"));
		store.deinit();
	}
	
	@Test
	public void a_remove() {
		init();
		store.init();
		Assert.assertTrue(store.removeUser("Bla"));
		store.deinit();
	}
}
