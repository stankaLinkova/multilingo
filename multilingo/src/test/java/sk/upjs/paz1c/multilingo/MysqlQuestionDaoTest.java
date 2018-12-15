package sk.upjs.paz1c.multilingo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import sk.upjs.paz1c.multilingo.entities.Question;
import sk.upjs.paz1c.multilingo.entities.School;
import sk.upjs.paz1c.multilingo.persistent.DaoFactory;
import sk.upjs.paz1c.multilingo.persistent.QuestionDao;
import sk.upjs.paz1c.multilingo.persistent.SchoolDao;
import sk.upjs.paz1c.multilingo.persistent.TestDao;

class MysqlQuestionDaoTest {

	private QuestionDao questionDao = DaoFactory.INSTANCE.getQuestionDao();
	private SchoolDao schoolDao = DaoFactory.INSTANCE.getSchoolDao();
	private TestDao testDao = DaoFactory.INSTANCE.getTestDao();
	
	
	
	@Test
	void testGetAll() {
		
		School school = new School();
		school.setName("GTA");
		school.setAddress("Zbrojnicna 3,KE");
		school.setEmail("gta@gta.sk");
		school.setLogin("gta4");
		school.setPassword("1234");
		Long idSchool = schoolDao.save(school).getId();
		
		
		sk.upjs.paz1c.multilingo.entities.Test test = new sk.upjs.paz1c.multilingo.entities.Test();
		test.setCreatedBy("GTA");	
		test.setNumberOfQuestions(4);
		test.setLanguage("German");
		test.setLevel("C1");
		test.setIdSchool(idSchool);
		test.setCreatedDate(LocalDate.of(2018, 11, 27));
		Long idTest = testDao.save(test).getId();
		
		Question question = new Question();
		question.setTask("Translate : dog");
		question.setRightAnswer("pes");
		question.setWrongAnswer1("macka");
		question.setWrongAnswer2("kuriatko");
		question.setWrongAnswer3("kohutik");
		question.setIdTest(idTest);
		 questionDao.save(question);
		
		assertTrue(questionDao.getAll().size() > 0);
		
		schoolDao.delete(idSchool);
		questionDao.delete(question.getId());
		testDao.delete(idTest);
		
	}

	@Test
	void testSave() {
		

		School school = new School();
		school.setName("GTA");
		school.setAddress("Zbrojnicna 3,KE");
		school.setEmail("gta@gta.sk");
		school.setLogin("gta4");
		school.setPassword("1234");
		Long idSchool = schoolDao.save(school).getId();
		
		
		sk.upjs.paz1c.multilingo.entities.Test test = new sk.upjs.paz1c.multilingo.entities.Test();
		test.setCreatedBy("GTA");	
		test.setNumberOfQuestions(4);
		test.setLanguage("German");
		test.setLevel("C1");
		test.setIdSchool(idSchool);
		test.setCreatedDate(LocalDate.of(2018, 11, 27));
		Long idTest = testDao.save(test).getId();
		
		Question question = new Question();
		question.setTask("Translate : dog");
		question.setRightAnswer("pes");
		question.setWrongAnswer1("macka");
		question.setWrongAnswer2("kuriatko");
		question.setWrongAnswer3("kohutik");
		question.setIdTest(idTest);
		int beforeSave = questionDao.getAll().size();
		Long id = questionDao.save(question).getId();
		int afterSave = questionDao.getAll().size();
		
		assertTrue(beforeSave == afterSave - 1);
		
		schoolDao.delete(idSchool);
		testDao.delete(idTest);
		questionDao.delete(id);
	}

	@Test
	void testDelete() {
		

		School school = new School();
		school.setName("GTA");
		school.setAddress("Zbrojnicna 3,KE");
		school.setEmail("gta@gta.sk");
		school.setLogin("gta4");
		school.setPassword("1234");
		Long idSchool = schoolDao.save(school).getId();
		
		
		sk.upjs.paz1c.multilingo.entities.Test test = new sk.upjs.paz1c.multilingo.entities.Test();
		test.setCreatedBy("GTA");	
		test.setNumberOfQuestions(4);
		test.setLanguage("German");
		test.setLevel("C1");
		test.setIdSchool(idSchool);
		test.setCreatedDate(LocalDate.of(2018, 11, 27));
		Long idTest = testDao.save(test).getId();
		
		
		Question question = new Question();
		question.setTask("Translate : dog");
		question.setRightAnswer("pes");
		question.setWrongAnswer1("macka");
		question.setWrongAnswer2("kuriatko");
		question.setWrongAnswer3("kohutik");
		question.setIdTest(idTest);
		Long id = questionDao.save(question).getId();
		
		int beforeDelete = questionDao.getAll().size();
		questionDao.delete(id);
		int afterDelete = questionDao.getAll().size();
		assertTrue(beforeDelete == afterDelete + 1);
		
		schoolDao.delete(idSchool);
		testDao.delete(idTest);
	}

}
