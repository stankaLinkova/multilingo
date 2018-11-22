package sk.upjs.paz1c.multilingo.persistent;

import java.util.List;

import sk.upjs.paz1c.multilingo.entities.Course;
import sk.upjs.paz1c.multilingo.entities.Student;


public interface CourseDao {

	List<Course> getAll();
	
	Course save(Course course);
	
	List<Student> getStudentsTakenTheCourse(long idCourse);
	
	void delete(long id);
}
