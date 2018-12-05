package sk.upjs.paz1c.multilingo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import sk.upjs.paz1c.multilingo.persistent.DaoFactory;
import sk.upjs.paz1c.multilingo.persistent.TestDao;

class MysqlTestDaoTest {
	
	
	
	private TestDao testDao = DaoFactory.INSTANCE.getTestDao();
	
	
	@Test
	void testGetAll() {
		assertTrue(testDao.getAll().size() > 0);
	}

	@Test
	void testSave() {
		sk.upjs.paz1c.multilingo.entities.Test test = new sk.upjs.paz1c.multilingo.entities.Test();
		test.setCreatedBy("GTA");
		
		test.setNumberOfQuestions(4);
		test.setLanguage("German");
		test.setLevel("C1");
		test.setIdSchool(1L);
		test.setCreatedDate(LocalDate.of(2018, 11, 27));
		
		int beforeSave = testDao.getAll().size();
		Long id = testDao.save(test).getId();
		int afterSave = testDao.getAll().size();
		
		assertTrue(beforeSave == afterSave - 1);
		
		testDao.delete(id);
	}

	@Test
	void testDelete() {
		sk.upjs.paz1c.multilingo.entities.Test test = new sk.upjs.paz1c.multilingo.entities.Test();
		test.setCreatedBy("GTA");
	
		test.setNumberOfQuestions(4);
		test.setLanguage("German");
		test.setLevel("C1");
		test.setIdSchool(1L);
		test.setCreatedDate(LocalDate.of(2018, 11, 27));
		
		Long id = testDao.save(test).getId();
		int beforeDelete = testDao.getAll().size();
		testDao.delete(id);
		int afterDelete = testDao.getAll().size();
		assertTrue(beforeDelete == afterDelete + 1);
	}

}
