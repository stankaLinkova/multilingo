package sk.upjs.paz1c.multilingo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sk.upjs.paz1c.multilingo.business.GeneralManager;

class GeneralManagerTest {

	@Test
	void hashPassword() {
		String password = "Ahoj";
		String password2 = "Ahoj";
		String returnPassword = GeneralManager.hashPassword(password);
		String returnPassword2 = GeneralManager.hashPassword(password2);
		assertTrue(returnPassword.equals(returnPassword2));
	}

}
