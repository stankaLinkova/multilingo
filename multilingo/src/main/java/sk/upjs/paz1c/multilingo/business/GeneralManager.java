package sk.upjs.paz1c.multilingo.business;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GeneralManager {

	
	public static String hashPassword(String password) {
		MessageDigest m;
		try {
			m = MessageDigest.getInstance("MD5");
			m.update(password.getBytes());
			byte[] digest = m.digest();
			BigInteger hashedPassword = new BigInteger(1, digest);
			return hashedPassword.toString();
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
}
