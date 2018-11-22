package sk.upjs.paz1c.multilingo.persistent;

import java.util.List;

import sk.upjs.paz1c.multilingo.entities.Course;
import sk.upjs.paz1c.multilingo.entities.School;
import sk.upjs.paz1c.multilingo.entities.Student;
import sk.upjs.paz1c.multilingo.entities.Test;


public interface StudentDao {

	Student save(Student student);

	void delete(long id);

	List<Object[]> getCompletedTests(long idStudent);

	List<Course> getMyCourses(long idStudent);
	
	void joinTheCourse(Student student, Course course);
 
	
}
