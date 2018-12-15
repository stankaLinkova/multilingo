package sk.upjs.paz1c.multilingo.persistent;

import java.time.LocalDate;
import java.util.List;

import sk.upjs.paz1c.multilingo.entities.Course;
import sk.upjs.paz1c.multilingo.entities.Student;
import sk.upjs.paz1c.multilingo.entities.Test;


public interface StudentDao {
	
	List<Student> getAll();
	
	Student save(Student student);

	void delete(long id);

	List<String> getCompletedTests(long idStudent);

	List<Course> getMyCourses(long idStudent);
	
	void doTheTest(Student student, Test test, LocalDate taken, int result);
	
	void joinTheCourse(Student student, Course course);
	
	Student getStudentByLogin(String login, String password);
	
	public void deleteCourse(long id);

 
	
}
