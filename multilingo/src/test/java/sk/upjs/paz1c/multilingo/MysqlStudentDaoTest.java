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
import sk.upjs.paz1c.multilingo.persistent.StudentDao;
import sk.upjs.paz1c.multilingo.persistent.TestDao;

class MysqlStudentDaoTest {

	private StudentDao studentDao = DaoFactory.INSTANCE.getStudentDao();
	private CourseDao courseDao = DaoFactory.INSTANCE.getCourseDao();
	private TestDao testDao = DaoFactory.INSTANCE.getTestDao();
	private SchoolDao schoolDao = DaoFactory.INSTANCE.getSchoolDao();

	@Test
	void testGetAll() {
		Student student = new Student();
		student.setName("Janko");
		student.setSurname("Hrasko");
		student.setEmail("jhrasko@gmail.com");
		student.setLogin("hraskoj5");
		student.setPassword("1235");
		Long id = studentDao.save(student).getId();
		
		assertNotNull(studentDao.getAll());
		studentDao.delete(id);
	}

	@Test
	void testSave() {
		Student student = new Student();
		student.setName("Janko");
		student.setSurname("Hrasko");
		student.setEmail("jhrasko@gmail.com");
		student.setLogin("hraskoj5");
		student.setPassword("1235");

		int beforeSave = studentDao.getAll().size();
		Long id = studentDao.save(student).getId();
		int afterSave = studentDao.getAll().size();

		assertTrue(beforeSave == afterSave - 1);

		studentDao.delete(id);
	}

	@Test
	void testDelete() {
		Student student = new Student();
		student.setName("Janko");
		student.setSurname("Hrasko");
		student.setEmail("jhrasko@gmail.com");
		student.setLogin("hraskoj4");
		student.setPassword("1234");

		Long id = studentDao.save(student).getId();
		int beforeDelete = studentDao.getAll().size();
		studentDao.delete(id);
		int afterDelete = studentDao.getAll().size();
		assertEquals(beforeDelete, afterDelete + 1);
	}

	@Test
	void testGetMyCourses() {

		School school = new School();
		school.setName("GTA");
		school.setAddress("Zbrojnicna 3,KE");
		school.setEmail("gta@gta.sk");
		school.setLogin("gta4");
		school.setPassword("1234");
		Long idSchool = schoolDao.save(school).getId();

		Student student = new Student();
		student.setName("Janko");
		student.setSurname("Hrasko");
		student.setEmail("jhrasko@gmail.com");
		student.setLogin("hraskoj3");
		student.setPassword("1233");
		Long id = studentDao.save(student).getId();

		Course course = new Course();
		course.setLanguageTaught("English");
		course.setTaughtIn("Slovak");
		course.setLevel("B2");
		course.setStartOfCourse(LocalDate.of(2018, 11, 5));
		course.setEndOfCourse(LocalDate.of(2018, 12, 5));
		course.setTimeOfLectures("16:30");
		course.setSchoolId(idSchool);
		Long idCourse = courseDao.save(course).getId();

		studentDao.joinTheCourse(student, course);

		assertTrue(studentDao.getMyCourses(id).size() > 0);
		studentDao.delete(id);
		courseDao.delete(idCourse);
		schoolDao.delete(idSchool);
	}

	@Test
	void testGetCompletedTests() {

		School school = new School();
		school.setName("GTA");
		school.setAddress("Zbrojnicna 3,KE");
		school.setEmail("gta@gta.sk");
		school.setLogin("gta4");
		school.setPassword("1234");
		Long idSchool = schoolDao.save(school).getId();

		Student student = new Student();
		student.setName("Janko");
		student.setSurname("Hrasko");
		student.setEmail("jhrasko@gmail.com");
		student.setLogin("hraskoj2");
		student.setPassword("1232");
		Long id = studentDao.save(student).getId();

		sk.upjs.paz1c.multilingo.entities.Test test = new sk.upjs.paz1c.multilingo.entities.Test();
		test.setCreatedBy("GTA");
		test.setNumberOfQuestions(4);
		test.setLanguage("German");
		test.setLevel("C1");
		test.setIdSchool(idSchool);
		test.setCreatedDate(LocalDate.of(2018, 11, 27));
		Long idTest = testDao.save(test).getId();

		int before = studentDao.getCompletedTests(id).size();
		studentDao.doTheTest(student, test, LocalDate.of(2018, 11, 27), 30);
		int after = studentDao.getCompletedTests(id).size();

		assertEquals(before, after - 1);
		studentDao.delete(id);
		testDao.delete(idTest);
		schoolDao.delete(idSchool);
	}

	@Test
	void testJoinTheCourse() {

		School school = new School();
		school.setName("GTA");
		school.setAddress("Zbrojnicna 3,KE");
		school.setEmail("gta@gta.sk");
		school.setLogin("gta4");
		school.setPassword("1234");
		Long idSchool = schoolDao.save(school).getId();

		Student student = new Student();
		student.setName("Janko");
		student.setSurname("Hrasko");
		student.setEmail("jhrasko@gmail.com");
		student.setLogin("hraskoj1");
		student.setPassword("1231");
		Long idStudent = studentDao.save(student).getId();

		Course course = new Course();
		course.setLanguageTaught("English");
		course.setTaughtIn("Slovak");
		course.setLevel("B2");
		course.setStartOfCourse(LocalDate.of(2018, 11, 5));
		course.setEndOfCourse(LocalDate.of(2018, 12, 5));
		course.setTimeOfLectures("16:30");
		course.setSchoolId(idSchool);
		Long idCourse = courseDao.save(course).getId();

		int beforeJoin = courseDao.getStudentsTakenTheCourse(idCourse).size();
		studentDao.joinTheCourse(student, course);
		int afterJoin = courseDao.getStudentsTakenTheCourse(idCourse).size();
		assertTrue(beforeJoin == afterJoin - 1);
		studentDao.delete(idStudent);
		courseDao.delete(idCourse);
		schoolDao.delete(idSchool);
	}

	@Test
	void getStudentByLoginTest() {
		Student student = new Student();
		student.setName("Janko");
		student.setSurname("Hrasko");
		student.setEmail("jhrasko@gmail.com");
		student.setLogin("hraskoj");
		student.setPassword("123");

		Long idStudent = studentDao.save(student).getId();
		Student studentNovy = studentDao.getStudentByLogin(student.getLogin(), student.getPassword());
		assertEquals(student.getId(), studentNovy.getId());
		studentDao.delete(idStudent);
	}

	@Test
	void testDeleteCourse() {

		School school = new School();
		school.setName("GTA");
		school.setAddress("Zbrojnicna 3,KE");
		school.setEmail("gta@gta.sk");
		school.setLogin("gta4");
		school.setPassword("1234");
		Long idSchool = schoolDao.save(school).getId();

		Student student = new Student();
		student.setName("Janko");
		student.setSurname("Hrasko");
		student.setEmail("jhrasko@gmail.com");
		student.setLogin("hraskoj1");
		student.setPassword("1231");
		Long idStudent = studentDao.save(student).getId();

		Course course = new Course();
		course.setLanguageTaught("English");
		course.setTaughtIn("Slovak");
		course.setLevel("B2");
		course.setStartOfCourse(LocalDate.of(2018, 11, 5));
		course.setEndOfCourse(LocalDate.of(2018, 12, 5));
		course.setTimeOfLectures("16:30");
		course.setSchoolId(idSchool);
		Long idCourse = courseDao.save(course).getId();
		studentDao.joinTheCourse(student, course);

		int beforeDelete = courseDao.getStudentsTakenTheCourse(idCourse).size();
		studentDao.deleteCourse(idCourse);
		int afterDelete = courseDao.getStudentsTakenTheCourse(idCourse).size();
		assertEquals(beforeDelete, afterDelete + 1);
		studentDao.delete(idStudent);
		courseDao.delete(idCourse);
		schoolDao.delete(idSchool);

	}

	@Test
	void testDoTheTest() {
		
		School school = new School();
		school.setName("GTA");
		school.setAddress("Zbrojnicna 3,KE");
		school.setEmail("gta@gta.sk");
		school.setLogin("gta4");
		school.setPassword("1234");
		Long idSchool = schoolDao.save(school).getId();

		Student student = new Student();
		student.setName("Janko");
		student.setSurname("Hrasko");
		student.setEmail("jhrasko@gmail.com");
		student.setLogin("hraskoj2");
		student.setPassword("1232");
		Long id = studentDao.save(student).getId();

		sk.upjs.paz1c.multilingo.entities.Test test = new sk.upjs.paz1c.multilingo.entities.Test();
		test.setCreatedBy("GTA");
		test.setNumberOfQuestions(4);
		test.setLanguage("German");
		test.setLevel("C1");
		test.setIdSchool(idSchool);
		test.setCreatedDate(LocalDate.of(2018, 11, 27));
		Long idTest = testDao.save(test).getId();

		int beforeDoing = studentDao.getCompletedTests(id).size();

		studentDao.doTheTest(student, test, LocalDate.of(2018, 11, 27), 30);

		int afterDoing = studentDao.getCompletedTests(id).size();

		assertTrue(beforeDoing == afterDoing - 1);
		studentDao.delete(id);
		testDao.delete(idTest);
		schoolDao.delete(idSchool);
	}
}
