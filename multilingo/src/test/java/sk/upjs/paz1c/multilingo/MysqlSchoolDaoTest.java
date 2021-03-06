package sk.upjs.paz1c.multilingo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import sk.upjs.paz1c.multilingo.entities.Course;
import sk.upjs.paz1c.multilingo.entities.School;
import sk.upjs.paz1c.multilingo.entities.Student;
import sk.upjs.paz1c.multilingo.persistent.CourseDao;
import sk.upjs.paz1c.multilingo.persistent.DaoFactory;
import sk.upjs.paz1c.multilingo.persistent.SchoolDao;
import sk.upjs.paz1c.multilingo.persistent.TestDao;

class MysqlSchoolDaoTest {

	private SchoolDao schoolDao = DaoFactory.INSTANCE.getSchoolDao();
	private TestDao testDao = DaoFactory.INSTANCE.getTestDao();
	private CourseDao courseDao = DaoFactory.INSTANCE.getCourseDao();
	
		
	@Test
	void testGetAll() {
		School school = new School();
		school.setName("GTA");
		school.setAddress("Zbrojnicna 3,KE");
		school.setEmail("gta@gta.sk");
		school.setLogin("gta4");
		school.setPassword("1234");
		Long id = schoolDao.save(school).getId();
		
		assertTrue(schoolDao.getAll().size() > 0);
		schoolDao.delete(id);
	}
	
	@Test
	void testSave() {
		School school = new School();
		school.setName("GTA");
		school.setAddress("Zbrojnicna 3,KE");
		school.setEmail("gta@gta.sk");
		school.setLogin("gta4");
		school.setPassword("1234");
		
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
		school.setLogin("gta3");
		school.setPassword("1233");
		
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
		school.setLogin("gta2");
		school.setPassword("1232");
		Long id = schoolDao.save(school).getId();
		
		Course course = new Course();
		course.setLanguageTaught("English");
		course.setTaughtIn("Slovak");
		course.setLevel("B2");
		course.setStartOfCourse(LocalDate.of(2018, 11, 5));
		course.setEndOfCourse(LocalDate.of(2018, 12, 5));
		course.setTimeOfLectures("16:30");
		course.setSchoolId(id);
		Long idCourse = courseDao.save(course).getId();
		
		assertTrue(schoolDao.getAllMyCourses(id).size() > 0);
		schoolDao.delete(id);
		courseDao.delete(idCourse);
	}

	@Test
	void testGetAllMyTests() {
		School school = new School();
		school.setName("GTA");
		school.setAddress("Zbrojnicna 3,KE");
		school.setEmail("gta@gta.sk");
		school.setLogin("gta1");
		school.setPassword("1231");
		Long idSchool = schoolDao.save(school).getId();
		
		sk.upjs.paz1c.multilingo.entities.Test test = new sk.upjs.paz1c.multilingo.entities.Test();
		test.setCreatedBy("GTA");
		test.setNumberOfQuestions(4);
		test.setLanguage("German");
		test.setLevel("C1");
		test.setIdSchool(idSchool);
		test.setCreatedDate(LocalDate.of(2018, 11, 27));
		Long id = testDao.save(test).getId();
		
		
		assertTrue(schoolDao.getAllMyTests(idSchool).size() > 0);
		schoolDao.delete(idSchool);
		testDao.delete(id);
	}

	@Test
	void getSchoolByLoginTest() {
		
		School school = new School();
		school.setName("GTA");
		school.setAddress("Zbrojnicna 3,KE");
		school.setEmail("gta@gta.sk");
		school.setLogin("gta");
		school.setPassword("123");
		
		Long idSchool = schoolDao.save(school).getId();
		
		School skolaNova = schoolDao.getSchoolByLogin(school.getLogin(),school.getPassword() );
		assertTrue(school.getId() == skolaNova.getId());
		schoolDao.delete(idSchool);
	}
}
