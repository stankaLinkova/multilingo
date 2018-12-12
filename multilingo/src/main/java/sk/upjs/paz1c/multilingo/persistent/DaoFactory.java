package sk.upjs.paz1c.multilingo.persistent;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.cj.jdbc.MysqlDataSource;

public enum DaoFactory {
	
	INSTANCE;

	private JdbcTemplate jdbcTemplate;
	private CourseDao courseDao;
	private SchoolDao schoolDao;
	private QuestionDao questionDao;
	private StudentDao studentDao;
	private TestDao testDao;
	
	public CourseDao getCourseDao() {
		if (courseDao == null)
			courseDao = new MysqlCourseDao(getJdbcTemplate());
		return courseDao;
	}
	
	public SchoolDao getSchoolDao() {
		if (schoolDao == null)
			schoolDao = new MysqlSchoolDao(getJdbcTemplate());
		return schoolDao;
	}
	
	public QuestionDao getQuestionDao() {
		if (questionDao == null)
			questionDao = new MysqlQuestionDao(getJdbcTemplate());
		return questionDao;
	}
	
	public StudentDao getStudentDao() {
		if (studentDao == null)
			studentDao = new MysqlStudentDao(getJdbcTemplate());
		return studentDao;
	}
	
	
	public TestDao getTestDao() {
		if (testDao == null)
			testDao = new MysqlTestDao(getJdbcTemplate());
		return testDao;
	}
	
	private JdbcTemplate getJdbcTemplate() {
		if (jdbcTemplate == null) {
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setUser("multilingo");
			dataSource.setPassword("multiLingo1");
			dataSource.setUrl("jdbc:mysql://localhost/multiLingo_project?serverTimezone=Europe/Bratislava");
			jdbcTemplate = new JdbcTemplate(dataSource);
		}
		return jdbcTemplate;
	}
	
}
