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

	
	public School save(School school) {
		if (school == null)
			return null;
		if (school.getId() == null) { 
			SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
			simpleJdbcInsert.withTableName("School");
			simpleJdbcInsert.usingGeneratedKeyColumns("idSchool");
			simpleJdbcInsert.usingColumns("Name", "Address", "Email");
			Map<String,Object> values = new HashMap<String, Object>();
			values.put("Name",school.getName());
			values.put("Address",school.getAddress());
			values.put("Email", school.getEmail());
			Long id = simpleJdbcInsert.executeAndReturnKey(values).longValue();
			school.setId(id);
		} else { 
			String sql = "UPDATE School SET "
					+ "Name = ?, Address = ?, Email = ? "
					+ "WHERE idSchool = ?";
			jdbcTemplate.update(sql,school.getName(),school.getAddress(),
					school.getEmail(), school.getId());
		}
		return school;
	}
		
	

	public void delete(long id) {
		String sql = "DELETE FROM School WHERE id = " + id;
		jdbcTemplate.update(sql);
		
	}


	public List<Course> getAllMyCourses(long idSchool) {
		String sql = "SELECT idCourse, language_taught, taught_in, level, start_of_course, end_of_course, "
				+ "time_of_lecture, information, School_id_School "
				+ "FROM Course WHERE  School_id_School = ?)";

		return jdbcTemplate.query(sql, new Object[]{idSchool}, new RowMapper<Course>() {

			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course course = new Course();
				course.setId(rs.getLong("idCourse"));
				course.setLanguageTaught(rs.getString("tanguage_tought"));
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

				course.setTimeOfLectures(rs.getString("time_of_lecture"));
				course.setInformation(rs.getString("information"));
				course.setSchoolId(rs.getLong("School_idSchool"));
				return course;

			}
		});
	}


	public List<Test> getAllMyTests(long idSchool) {
		String sql = "SELECT idTest, created_by, created_date, "
				+ "number_of_questions, language, level, "
				+ "information, School_idSchool FROM Test "
				+ "WHERE School_idSchool= ? ";
		return jdbcTemplate.query(sql, new Object[]{idSchool}, new RowMapper<Test>() {

			public Test mapRow(ResultSet rs, int rowNum) throws SQLException {
				Test test = new Test();
				test.setId(rs.getLong("idTest"));
				test.setCreatedBy(rs.getString("created_by"));
				
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


}
