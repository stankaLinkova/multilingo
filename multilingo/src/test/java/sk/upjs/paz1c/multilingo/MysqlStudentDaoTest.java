package sk.upjs.paz1c.multilingo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import sk.upjs.paz1c.multilingo.entities.Course;
import sk.upjs.paz1c.multilingo.entities.School;
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
		assertTrue(studentDao.getAll().size() > 1);
	}
	
	@Test
	void testSave() {
		Student student = new Student();
		student.setName("Janko");
		student.setSurname("Hrasko");
		student.setEmail("jhrasko@gmail.com");
		
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

}
