package sk.upjs.paz1c.multilingo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import sk.upjs.paz1c.multilingo.entities.Course;
import sk.upjs.paz1c.multilingo.entities.School;
import sk.upjs.paz1c.multilingo.persistent.DaoFactory;
import sk.upjs.paz1c.multilingo.persistent.SchoolDao;

class MysqlSchoolDaoTest {

	private SchoolDao schoolDao = DaoFactory.INSTANCE.getSchoolDao();
	private long id;
	
//	@Test
//	void testSave() {
//		int beforeSave = schoolDao.getAll().size();
//		schoolDao.save(school);
//		int afterSave = schoolDao.getAll().size();
//		assertTrue(beforeSave == afterSave - 1);
//	}

	
	// nemame metodu GETALL..taze zatial neviem
	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllMyCourses() {
		assertTrue(schoolDao.getAllMyCourses(id).size() == 0);
	}

	@Test
	void testGetAllMyTests() {
		assertTrue(schoolDao.getAllMyTests(id).size() == 0);
	}

}
