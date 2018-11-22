package sk.upjs.paz1c.multilingo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import sk.upjs.paz1c.multilingo.persistent.DaoFactory;
import sk.upjs.paz1c.multilingo.persistent.TestDao;

class MysqlTestDaoTest {
	
	
	//TODO aj @test aj entita sa volaju ROVNAKO, eclipse ma PROBLEM!!!
	private TestDao testDao = DaoFactory.INSTANCE.getTestDao();
	private sk.upjs.paz1c.multilingo.entities.Test test = new sk.upjs.paz1c.multilingo.entities.Test();
	private long id;

	
	@Test
	void testGetAll() {
		assertTrue(testDao.getAll().size() > 0);
	}

	@Test
	void testSave() {
		int beforeSave = testDao.getAll().size();
		testDao.save(test);
		int afterSave = testDao.getAll().size();
		assertTrue(beforeSave == afterSave - 1);
	}

	@Test
	void testDelete() {
		int beforeDelete = testDao.getAll().size();
		testDao.delete(id);
		int afterDelete = testDao.getAll().size();
		assertTrue(beforeDelete == afterDelete + 1);
	}

}
