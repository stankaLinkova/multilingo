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

class MysqlTestDaoTest {
	
	private TestDao testDao = DaoFactory.INSTANCE.getTestDao();
	private QuestionDao questionDao = DaoFactory.INSTANCE.getQuestionDao();
	private SchoolDao schoolDao = DaoFactory.INSTANCE.getSchoolDao();
	
	
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
		
		assertTrue(testDao.getAll().size() > 0);
		testDao.delete(idTest);
		schoolDao.delete(idSchool);
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
		
		int beforeSave = testDao.getAll().size();
		Long id = testDao.save(test).getId();
		int afterSave = testDao.getAll().size();
		
		assertTrue(beforeSave == afterSave - 1);
		
		testDao.delete(id);
		schoolDao.delete(idSchool);
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
		
		Long id = testDao.save(test).getId();
		int beforeDelete = testDao.getAll().size();
		testDao.delete(id);
		schoolDao.delete(idSchool);
		int afterDelete = testDao.getAll().size();
		assertTrue(beforeDelete == afterDelete + 1);

	}
	
	@Test
	void getAllMyQuestions() {
		
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
		
		
		int before = testDao.getAllMyQuestions(idTest).size();
		questionDao.delete(id);
		schoolDao.delete(idSchool);
		testDao.delete(idTest);
		int after = testDao.getAllMyQuestions(idTest).size();
		assertTrue(before == after + 1);
	}

}
