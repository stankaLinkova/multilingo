package sk.upjs.paz1c.multilingo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sk.upjs.paz1c.multilingo.business.SignUpAsStudentManager;
import sk.upjs.paz1c.multilingo.entities.Student;

class SignUpAsStudentManagerTest {

	@Test
	void testCanCreate() {
		Student student = new Student();
		student.setName("Janko");
		student.setSurname("Hrasko");
		student.setEmail("jhrasko@gmail.com");
		student.setLogin("hraskoj2");
		student.setPassword("1232");

		String confirmationPassword = "1232";
		
		SignUpAsStudentManager manager = new SignUpAsStudentManager();
		
		assertTrue(manager.canCreate(student, confirmationPassword));
	}
	
	@Test
	void testCanCreate2() {
		Student student = new Student();
		student.setName("Janko");
		student.setSurname("Hrasko");
		student.setEmail("jhrasko@gmail.com");
		student.setLogin("hraskoj2");
		student.setPassword("1232");

		String confirmationPassword = "123";
		
		SignUpAsStudentManager manager = new SignUpAsStudentManager();
		
		assertTrue(!manager.canCreate(student, confirmationPassword));
	}


}
