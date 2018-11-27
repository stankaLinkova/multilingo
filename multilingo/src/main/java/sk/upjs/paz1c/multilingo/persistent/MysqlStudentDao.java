package sk.upjs.paz1c.multilingo.persistent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import sk.upjs.paz1c.multilingo.entities.Course;
import sk.upjs.paz1c.multilingo.entities.Student;
import sk.upjs.paz1c.multilingo.entities.Test;

public class MysqlStudentDao implements StudentDao {

	private JdbcTemplate jdbcTemplate;

	public MysqlStudentDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Student> getAll() {
		String sql = "SELECT idStudent, name, surname, email " + "FROM Student";

		return jdbcTemplate.query(sql, new RowMapper<Student>() {

			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				student.setId(rs.getLong("idStudent"));
				student.setName(rs.getString("name"));
				student.setSurname(rs.getString("surname"));
				student.setEmail(rs.getString("email"));

				return student;

			}
		});

	}

	public Student save(Student student) {
		if (student == null)
			return null;
		if (student.getId() == null) {
			SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
			simpleJdbcInsert.withTableName("Student");
			simpleJdbcInsert.usingGeneratedKeyColumns("idStudent");
			simpleJdbcInsert.usingColumns("name", "surname", "e-mail");
			Map<String, Object> values = new HashMap<String, Object>();
			values.put("name", student.getName());
			values.put("surname", student.getSurname());
			values.put("e-mail", student.getEmail());
			Long id = simpleJdbcInsert.executeAndReturnKey(values).longValue();
			student.setId(id);
		} else {
			String sql = "UPDATE Student SET " + "name = ?, surname = ?, e-mail = ? " + "WHERE idStudent = ?";
			jdbcTemplate.update(sql, student.getName(), student.getSurname(), student.getEmail(), student.getId());
		}
		return student;
	}

	public void delete(long id) {
		String sql = "DELETE FROM Student WHERE id = " + id;
		jdbcTemplate.update(sql);

	}

	public List<Course> getMyCourses(long idStudent) {
		String sql = "SELECT idCourse, language_taught, taught_in, level, start_of_course, end_of_course, "
				+ "time_of_lecture, information, School_id_School "
				+ "FROM Course WHERE Course_idCourse IN (SELECT Course_idCourse FROM Course_has_Student "
				+ "WHERE Student_idStudent = ?)";

		return jdbcTemplate.query(sql, new Object[] { idStudent }, new RowMapper<Course>() {

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

	public List<Object[]> getCompletedTests(long idStudent) {
		String sql = "SELECT sht.taken, sht.result, t.language, t.level " + "FROM Student_has_Test as sht "
				+ "JOIN Test as t ON t.idTest = sht.Test_idTest " + "WHERE sht.Student_idStudent = ? ";
		return jdbcTemplate.query(sql, new Object[] { idStudent }, new RowMapper<Object[]>() {

			public Object[] mapRow(ResultSet rs, int rowNum) throws SQLException {
				Object[] values = new Object[4];
				values[0] = rs.getTimestamp("sht.taken").toLocalDateTime().toLocalDate();
				values[1] = rs.getInt("sht.result");
				values[2] = rs.getString("t.language");
				values[3] = rs.getString("t.level");

				return values;
			}

		});

	}

	public void joinTheCourse(Student student, Course course) {
		String sql = "INSERT INTO Course_has_Student (Course_idCourse, Student_idStudent) VALUES (?,?)";
		Object[] parameters = new Object[] { course.getId(), student.getId() };
		int[] types = new int[] { Types.INTEGER, Types.INTEGER };
		jdbcTemplate.update(sql, parameters, types);
	}

}
