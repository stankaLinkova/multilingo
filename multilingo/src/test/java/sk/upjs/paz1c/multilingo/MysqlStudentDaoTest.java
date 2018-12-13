package sk.upjs.paz1c.multilingo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import sk.upjs.paz1c.multilingo.entities.Course;
import sk.upjs.paz1c.multilingo.entities.Student;
import sk.upjs.paz1c.multilingo.persistent.CourseDao;
import sk.upjs.paz1c.multilingo.persistent.DaoFactory;
import sk.upjs.paz1c.multilingo.persistent.StudentDao;
import sk.upjs.paz1c.multilingo.persistent.TestDao;

class MysqlStudentDaoTest {

	private StudentDao studentDao = DaoFactory.INSTANCE.getStudentDao();
	private CourseDao courseDao = DaoFactory.INSTANCE.getCourseDao();
	private TestDao testDao = DaoFactory.INSTANCE.getTestDao();

	@Test
	void testGetAll() {
		assertNotNull(studentDao.getAll());
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
		course.setSchoolId(1L);
		Long idCourse = courseDao.save(course).getId();

		studentDao.joinTheCourse(student, course);

		assertTrue(studentDao.getMyCourses(id).size() > 0);
		studentDao.delete(id);
		courseDao.delete(idCourse);
	}

	@Test
	void testGetCompletedTests() {
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
		test.setIdSchool(1L);
		test.setCreatedDate(LocalDate.of(2018, 11, 27));
		Long idTest = testDao.save(test).getId();

		studentDao.doTheTest(student, test, LocalDate.of(2018, 11, 27), 30);

		assertTrue(studentDao.getCompletedTests(id).size() > 0);
		studentDao.delete(id);
		testDao.delete(idTest);
	}

	@Test
	void testJoinTheCourse() {
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
		course.setSchoolId(1L);
		Long idCourse = courseDao.save(course).getId();

		int beforeJoin = courseDao.getStudentsTakenTheCourse(idCourse).size();
		studentDao.joinTheCourse(student, course);
		int afterJoin = courseDao.getStudentsTakenTheCourse(idCourse).size();
		assertTrue(beforeJoin == afterJoin - 1);
		studentDao.delete(idStudent);
		courseDao.delete(idCourse);
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
		course.setSchoolId(1L);
		Long idCourse = courseDao.save(course).getId();
		studentDao.joinTheCourse(student, course);

		int beforeDelete = courseDao.getStudentsTakenTheCourse(idCourse).size();
		studentDao.deleteCourse(idCourse);
		int afterDelete = courseDao.getStudentsTakenTheCourse(idCourse).size();
		assertEquals(beforeDelete,afterDelete + 1);
		studentDao.delete(idStudent);
		courseDao.delete(idCourse);

	}

	@Test
	void testDeleteTest() {
		
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
		test.setIdSchool(1L);
		test.setCreatedDate(LocalDate.of(2018, 11, 27));
		Long idTest = testDao.save(test).getId();
		studentDao.doTheTest(student, test, LocalDate.of(2018, 11, 27), 30);

		
		int beforeDelete = studentDao.getCompletedTests(id).size();
		studentDao.deleteTest(idTest);
		int afterDelete = studentDao.getCompletedTests(id).size();
		assertEquals(beforeDelete,afterDelete + 1);
		studentDao.delete(id);
		courseDao.delete(idTest);
	}
	
	@Test
	void testDoTheTest() {
		
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
		test.setIdSchool(1L);
		test.setCreatedDate(LocalDate.of(2018, 11, 27));
		Long idTest = testDao.save(test).getId();

		int beforeDoing = studentDao.getCompletedTests(id).size();
		
		studentDao.doTheTest(student, test, LocalDate.of(2018, 11, 27), 30);
		
		int afterDoing = studentDao.getCompletedTests(id).size();

		assertTrue(beforeDoing == afterDoing - 1);
		studentDao.delete(id);
		testDao.delete(idTest);
	}
}

