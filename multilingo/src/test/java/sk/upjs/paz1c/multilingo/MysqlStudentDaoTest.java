package sk.upjs.paz1c.multilingo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import sk.upjs.paz1c.multilingo.entities.Course;
import sk.upjs.paz1c.multilingo.entities.School;
import sk.upjs.paz1c.multilingo.entities.Student;
import sk.upjs.paz1c.multilingo.persistent.CourseDao;
import sk.upjs.paz1c.multilingo.persistent.DaoFactory;
import sk.upjs.paz1c.multilingo.persistent.StudentDao;

class MysqlStudentDaoTest {

	
	private StudentDao studentDao = DaoFactory.INSTANCE.getStudentDao();
	private CourseDao courseDao = DaoFactory.INSTANCE.getCourseDao();
	private Student student = new Student();
	private Course course = new Course();
	private long id;
	
	
	
	//NEMAME GETALL METODU!!!
//	@Test
//	void testSave() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDelete() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetMyCourses() {
		assertTrue(studentDao.getMyCourses(id).size() == 0);
	}

	@Test
	void testGetCompletedTests() {
		assertTrue(studentDao.getCompletedTests(id).size() == 0);
	}

	@Test
	void testJoinTheCourse() {
		int beforeJoin = courseDao.getStudentsTakenTheCourse(id).size();
		studentDao.joinTheCourse(student, course);
		int afterJoin = courseDao.getStudentsTakenTheCourse(id).size();
		assertTrue(beforeJoin == afterJoin - 1);
	}

}
