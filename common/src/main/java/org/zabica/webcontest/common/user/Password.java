package org.zabica.webcontest.common.user;

import java.io.Serializable;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import org.apache.commons.codec.binary.Base64;

public class Password implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -80392116173513730L;
	
	private String hash;
	
	public Password() {
	}
	
	public Password(String hash) {
		this.hash = hash;
	}
	
    private static final int iterations = 10*1024;
    private static final int saltLen = 32;
    private static final int desiredKeyLen = 256;

    public boolean isValid(String password) {
        String[] saltAndPass = this.hash.split("\\$");
        if (saltAndPass.length != 2)
            return false;
        String hashOfInput;
		try {
			hashOfInput = hash(password, Base64.decodeBase64(saltAndPass[0]));
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			return false;
		}
        return hashOfInput.equals(saltAndPass[1]);
    }

    public static Password encryptPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(saltLen);
        
        //Returning new instance of this object
        return new Password(Base64.encodeBase64String(salt) + "$" + hash(password, salt));
    }

    /**
     * Let's create a shash of the password 
     * 
     * @param password
     * @param salt
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    private static String hash(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        if (password == null || password.length() == 0)
            throw new IllegalArgumentException("Empty passwords are not supported.");
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        SecretKey key = f.generateSecret(new PBEKeySpec(
            password.toCharArray(), salt, iterations, desiredKeyLen)
        );
        return Base64.encodeBase64String(key.getEncoded());
    }
}