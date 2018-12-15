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

class MysqlCourseDaoTest {

	private CourseDao courseDao = DaoFactory.INSTANCE.getCourseDao();
	private StudentDao studentDao = DaoFactory.INSTANCE.getStudentDao();
	private SchoolDao schoolDao = DaoFactory.INSTANCE.getSchoolDao();

	@Test
	void testGetAll() {
		assertTrue(courseDao.getAll().size() > 0);
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
		
		Course course = new Course();
		course.setLanguageTaught("English");
		course.setTaughtIn("Slovak");
		course.setLevel("B2");
		course.setStartOfCourse(LocalDate.of(2018, 11, 5));
		course.setEndOfCourse(LocalDate.of(2018, 12, 5));
		course.setTimeOfLectures("16:30");
		course.setSchoolId(idSchool);
		int beforeSave = courseDao.getAll().size();
		Long id = courseDao.save(course).getId();
		int afterSave = courseDao.getAll().size();
		assertTrue(beforeSave == afterSave - 1);
		
		schoolDao.delete(idSchool);
		courseDao.delete(id);
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
		
		Course course = new Course();
		course.setLanguageTaught("English");
		course.setTaughtIn("Slovak");
		course.setLevel("B2");
		course.setStartOfCourse(LocalDate.of(2018, 11, 5));
		course.setEndOfCourse(LocalDate.of(2018, 12, 5));
		course.setTimeOfLectures("16:30");
		course.setSchoolId(idSchool);
		
		Long id = courseDao.save(course).getId();
		int beforeDelete = courseDao.getAll().size();
		courseDao.delete(id);
		int afterDelete = courseDao.getAll().size();
		assertEquals(beforeDelete, afterDelete + 1);
		
		schoolDao.delete(idSchool);
	}

	
		@Test
		void testGetStudentsTakenTheCourse() {
			
			School school = new School();
			school.setName("GTA");
			school.setAddress("Zbrojnicna 3,KE");
			school.setEmail("gta@gta.sk");
			school.setLogin("gta4");
			school.setPassword("1234");
			Long idSchool = schoolDao.save(school).getId();
			
			Course course = new Course();
			course.setLanguageTaught("English");
			course.setTaughtIn("Slovak");
			course.setLevel("B2");
			course.setStartOfCourse(LocalDate.of(2018, 11, 5));
			course.setEndOfCourse(LocalDate.of(2018, 12, 5));
			course.setTimeOfLectures("16:30");
			course.setSchoolId(idSchool);
			Long idCourse = courseDao.save(course).getId();
			
			Student student = new Student();
			student.setName("Janko");
			student.setSurname("Hrasko");
			student.setEmail("jhrasko@gmail.com");
			student.setLogin("hraskoj6");
			student.setPassword("1236");
			Long idStudent = studentDao.save(student).getId();
			
			studentDao.joinTheCourse(student, course);
			int numberOfStudents = courseDao.getStudentsTakenTheCourse(idCourse).size();
			
			assertTrue(numberOfStudents == 1);
			
			schoolDao.delete(idSchool);
			courseDao.delete(idCourse);
			studentDao.delete(idStudent);
		}

}
