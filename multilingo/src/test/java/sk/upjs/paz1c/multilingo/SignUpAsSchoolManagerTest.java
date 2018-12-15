package sk.upjs.paz1c.multilingo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sk.upjs.paz1c.multilingo.business.SignUpAsSchoolManager;
import sk.upjs.paz1c.multilingo.entities.School;

class SignUpAsSchoolManagerTest {

	@Test
	void testCanCreate() {
		School school = new School();
		school.setName("GTA");
		school.setAddress("Zbrojnicna 3,KE");
		school.setEmail("gta@gta.sk");
		school.setLogin("gta4");
		school.setPassword("1234");
		
		String confirmationPassword = "1234";
		
		SignUpAsSchoolManager manager = new SignUpAsSchoolManager();
		
		assertTrue(manager.canCreate(school, confirmationPassword));
		
		
	}
	
	@Test
	void testCanCreate2() {
		School school = new School();
		school.setName("GTA");
		school.setAddress("Zbrojnicna 3,KE");
		school.setEmail("gta@gta.sk");
		school.setLogin("gta4");
		school.setPassword("1234");
		
		String confirmationPassword = "124";
		
		SignUpAsSchoolManager manager = new SignUpAsSchoolManager();
		
		assertTrue(!manager.canCreate(school, confirmationPassword));
	}

}
