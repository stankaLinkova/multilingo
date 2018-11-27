package sk.upjs.paz1c.multilingo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import sk.upjs.paz1c.multilingo.entities.Course;
import sk.upjs.paz1c.multilingo.entities.School;
import sk.upjs.paz1c.multilingo.persistent.DaoFactory;
import sk.upjs.paz1c.multilingo.persistent.SchoolDao;

class MysqlSchoolDaoTest {

	private SchoolDao schoolDao = DaoFactory.INSTANCE.getSchoolDao();
	
	
	//TUTO TRIEDU SOM DOST PREROBILA..SKOPIRUJ SI TO!!
	
	@Test
	void testGetAll() {
		assertTrue(schoolDao.getAll().size() > 1);
	}
	
	@Test
	void testSave() {
		School school = new School();
		school.setName("GTA");
		school.setAddress("Zbrojnicna 3,KE");
		school.setEmail("gta@gta.sk");
		
		int beforeSave = schoolDao.getAll().size();
		Long id = schoolDao.save(school).getId();
		int afterSave = schoolDao.getAll().size();
		assertTrue(beforeSave == afterSave - 1);
		schoolDao.delete(id);
	}

	
	@Test
	void testDelete() {
		School school = new School();
		school.setName("GTA");
		school.setAddress("Zbrojnicna 3,KE");
		school.setEmail("gta@gta.sk");
		
		Long id = schoolDao.save(school).getId();
		int beforeDelete = schoolDao.getAll().size();
		schoolDao.delete(id);
		int afterDelete = schoolDao.getAll().size();
		assertEquals(beforeDelete, afterDelete + 1);
	}

	@Test
	void testGetAllMyCourses() {
		School school = new School();
		school.setName("GTA");
		school.setAddress("Zbrojnicna 3,KE");
		school.setEmail("gta@gta.sk");
		
		Long id = schoolDao.save(school).getId();
		assertTrue(schoolDao.getAllMyCourses(id).size() > 0);
		schoolDao.delete(id);
	}

	@Test
	void testGetAllMyTests() {
		School school = new School();
		school.setName("GTA");
		school.setAddress("Zbrojnicna 3,KE");
		school.setEmail("gta@gta.sk");
		
		Long id = schoolDao.save(school).getId();
		assertTrue(schoolDao.getAllMyTests(id).size() > 0);
		schoolDao.delete(id);
	}

}
