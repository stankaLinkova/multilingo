package sk.upjs.paz1c.multilingo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import sk.upjs.paz1c.multilingo.entities.Course;
import sk.upjs.paz1c.multilingo.entities.Question;
import sk.upjs.paz1c.multilingo.persistent.DaoFactory;
import sk.upjs.paz1c.multilingo.persistent.QuestionDao;

class MysqlQuestionDaoTest {

	private QuestionDao questionDao = DaoFactory.INSTANCE.getQuestionDao();
	
	
	
	@Test
	void testGetAll() {
		assertTrue(questionDao.getAll().size() > 0);
	}

	@Test
	void testSave() {
		Question question = new Question();
		question.setTask("Translate : dog");
		question.setRightAnswer("pes");
		question.setWrongAnswer1("macka");
		question.setWrongAnswer2("kuriatko");
		question.setWrongAnswer3("kohutik");
		question.setIdTest(1L);
		int beforeSave = questionDao.getAll().size();
		Long id = questionDao.save(question).getId();
		int afterSave = questionDao.getAll().size();
		
		assertTrue(beforeSave == afterSave - 1);
		
		questionDao.delete(id);
	}

	@Test
	void testDelete() {
		Question question = new Question();
		question.setTask("Translate : dog");
		question.setRightAnswer("pes");
		question.setWrongAnswer1("macka");
		question.setWrongAnswer2("kuriatko");
		question.setWrongAnswer3("kohutik");
		question.setIdTest(1L);
		Long id = questionDao.save(question).getId();
		
		int beforeDelete = questionDao.getAll().size();
		questionDao.delete(id);
		int afterDelete = questionDao.getAll().size();
		assertTrue(beforeDelete == afterDelete + 1);
	}

}
