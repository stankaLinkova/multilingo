package sk.upjs.paz1c.multilingo.persistent;

import java.util.List;

import sk.upjs.paz1c.multilingo.entities.Course;
import sk.upjs.paz1c.multilingo.entities.School;
import sk.upjs.paz1c.multilingo.entities.Test;

public interface SchoolDao {
	
	List<School> getAll();
	
	School save(School school);

	void delete(long id);

	List<Course> getAllMyCourses(long idSchool);
	
	List<Test> getAllMyTests(long idSchool);

	School getSchoolByLogin(String login, String password);
	
	
	
	

}
