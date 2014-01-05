package org.zabica.webcontest.common.user;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.junit.Assert;
import org.junit.Test;

public class PasswordEncryptionTest {

	@Test
	public void test() throws NoSuchAlgorithmException, InvalidKeySpecException {
		String p1 = "password1";
		String p2 = "password2";
		
		Password p = Password.encryptPassword(p1);
		
		Assert.assertTrue(p.isValid(p1));
		Assert.assertFalse(p.isValid(p2));
	}

}
