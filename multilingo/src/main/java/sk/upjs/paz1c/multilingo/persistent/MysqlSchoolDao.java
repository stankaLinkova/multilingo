package sk.upjs.paz1c.multilingo.persistent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import sk.upjs.paz1c.multilingo.entities.Course;
import sk.upjs.paz1c.multilingo.entities.School;
import sk.upjs.paz1c.multilingo.entities.Test;

public class MysqlSchoolDao implements SchoolDao {

	private JdbcTemplate jdbcTemplate;

	public MysqlSchoolDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

 //pomocna pri testoch
	public List<School> getAll() {
		String sql = "SELECT idSchool, name, Address, email, login, password " + "FROM School";

		return jdbcTemplate.query(sql, new RowMapper<School>() {

			public School mapRow(ResultSet rs, int rowNum) throws SQLException {
				School school = new School();
				school.setId(rs.getLong("idSchool"));
				school.setName(rs.getString("name"));
				school.setAddress(rs.getString("Address"));
				school.setEmail(rs.getString("email"));
				school.setLogin(rs.getString("login"));
				school.setPassword(rs.getString("password"));

				return school;

			}
		});

	}

	public School save(School school) {
		if (school == null)
			return null;
		if (school.getId() == null) {
			SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
			simpleJdbcInsert.withTableName("School");
			simpleJdbcInsert.usingGeneratedKeyColumns("idSchool");
			simpleJdbcInsert.usingColumns("Name", "Address", "Email", "login", "password");
			Map<String, Object> values = new HashMap<String, Object>();
			values.put("Name", school.getName());
			values.put("Address", school.getAddress());
			values.put("Email", school.getEmail());
			values.put("login", school.getLogin());
			values.put("password", school.getPassword());
			Long id = simpleJdbcInsert.executeAndReturnKey(values).longValue();
			school.setId(id);
		} else {
			String sql = "UPDATE School SET " + "Name = ?, Address = ?, Email = ?, login = ?, password = ? "
					+ "WHERE idSchool = ?";
			jdbcTemplate.update(sql, school.getName(), school.getAddress(), school.getEmail(), school.getLogin(),
					school.getPassword(), school.getId());
		}
		return school;
	}

	public void delete(long id) {
		String sql = "DELETE FROM School WHERE idSchool = " + id;
		jdbcTemplate.update(sql);

	}

	//na profil skoly
	public List<Course> getAllMyCourses(long idSchool) {
		String sql = "SELECT idCourse, language_taught, taught_in, level, start_of_course,"
				+ "end_of_course, time_of_lectures, information,"
				+ "School_idSchool " + "FROM Course WHERE  School_idSchool = ?";

		return jdbcTemplate.query(sql, new Object[] { idSchool }, new RowMapper<Course>() {

			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course course = new Course();
				course.setId(rs.getLong("idCourse"));
				course.setLanguageTaught(rs.getString("language_taught"));
				course.setTaughtIn(rs.getString("taught_in"));
				course.setLevel(rs.getString("level"));

				Timestamp timestamp = rs.getTimestamp("start_of_course");
				if (timestamp != null) {
					course.setStartOfCourse(timestamp.toLocalDateTime().toLocalDate());
				}

				timestamp = rs.getTimestamp("end_of_course");
				if (timestamp != null) {
					course.setEndOfCourse(timestamp.toLocalDateTime().toLocalDate());
				}

				course.setTimeOfLectures(rs.getString("time_of_lectures"));
				course.setInformation(rs.getString("information"));
				course.setSchoolId(rs.getLong("School_idSchool"));
				return course;

			}
		});
	}

	// na profil skoly
	public List<Test> getAllMyTests(long idSchool) {
		String sql = "SELECT idTest, language, level, created_date, number_of_questions," 
				+ "School_idSchool FROM Test " + "WHERE School_idSchool= ? ";
		return jdbcTemplate.query(sql, new Object[] { idSchool }, new RowMapper<Test>() {

			public Test mapRow(ResultSet rs, int rowNum) throws SQLException {
				Test test = new Test();
				test.setId(rs.getLong("idTest"));

				Timestamp timestamp = rs.getTimestamp("created_date");
				if (timestamp != null) {
					test.setCreatedDate(timestamp.toLocalDateTime().toLocalDate());
				}

				test.setNumberOfQuestions(rs.getInt("number_of_questions"));
				test.setLanguage(rs.getString("language"));
				test.setLevel(rs.getString("level"));
				test.setIdSchool(rs.getLong("School_idSchool"));
				
				return test;

			}
		});
	}
	
	
	// aby sme pri prihlaseni vedeli, ktorej skoly profil mame zobrazit
	public School getSchoolByLogin(String login, String password) {
		String sql = "SELECT idSchool, name, address, email, login FROM School WHERE login = ? and password = ?";
		Object[] params = new Object[] { login, password };
		List<School> schools = jdbcTemplate.query(sql, params, new RowMapper<School>() {

			public School mapRow(ResultSet rs, int rowNum) throws SQLException {
				
					School school = new School();
					school.setId(rs.getLong("idSchool"));
					school.setName(rs.getString("name"));
					school.setAddress(rs.getString("Address"));
					school.setEmail(rs.getString("email"));
					school.setLogin(rs.getString("login"));

					return school;
				}

		
		});
		if (schools.size() == 0) {
			return null;
		} else {
			return schools.get(0);
		}
	}

}
