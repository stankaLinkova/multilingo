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
import sk.upjs.paz1c.multilingo.entities.Question;
import sk.upjs.paz1c.multilingo.entities.Test;

public class MysqlTestDao implements TestDao {
	
	private JdbcTemplate jdbcTemplate;
	

	public MysqlTestDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Test> getAll() {
		String sql = "SELECT idTest, created_by, created_date, number_of_questions, language,  "
				+ " level, School_idSchool  "
				+ "FROM Test";

		return jdbcTemplate.query(sql, new RowMapper<Test>() {

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

	public Test save(Test test) {
		if (test == null)
			return null;
		if (test.getId() == null) { 
			SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
			simpleJdbcInsert.withTableName("Test");
			simpleJdbcInsert.usingGeneratedKeyColumns("idTest");
			simpleJdbcInsert.usingColumns("created_by", "created_date", "number_of_questions", "language",
					"level", "School_idSchool");
			Map<String,Object> values = new HashMap<String, Object>();
			values.put("created_by",test.getCreatedBy());
			values.put("created_date",test.getCreatedDate());
			values.put("number_of_questions", test.getNumberOfQuestions());
			values.put("language", test.getLanguage());
			values.put("level", test.getLevel());
			values.put("School_idSchool", test.getIdSchool());
			Long id = simpleJdbcInsert.executeAndReturnKey(values).longValue();
			test.setId(id);
		} else { 
			String sql = "UPDATE Test SET "
					+ "created_by = ?, created_date = ?, number_of_questions = ?, language = ?, "
					+ "level = ?, School_idSchool = ? "
					+ "WHERE idTest = ?";
			jdbcTemplate.update(sql, test.getCreatedBy(), test.getCreatedDate(),
					test.getNumberOfQuestions(), test.getLanguage(),
					test.getLevel(),
					test.getIdSchool(), test.getId());
		}
		return test;
		
	}

	public void delete(long id) {
		String sql = "DELETE FROM Test WHERE idTest = " + id;
		jdbcTemplate.update(sql);
		
	}

	// aby student mohol robit otazky, ktore su v tom teste, nie ine
	public List<Question> getAllMyQuestions(Long idTest) {
		String sql = "SELECT idQuestion, task, right_answer, wrong_answer_1, wrong_answer_2, "
				+ "wrong_answer_3, wrong_answer_4 FROM Question WHERE Test_idTest = ? ";

		return jdbcTemplate.query(sql, new Object[] { idTest }, new RowMapper<Question>() {

			public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
				Question question = new Question();
				question.setId(rs.getLong("idQuestion"));
				question.setTask(rs.getString("task"));
				question.setRightAnswer(rs.getString("right_answer"));
				question.setWrongAnswer1(rs.getString("wrong_answer_1"));
				question.setWrongAnswer2(rs.getString("wrong_answer_2"));
				question.setWrongAnswer3(rs.getString("wrong_answer_3"));
				question.setWrongAnswer4(rs.getString("wrong_answer_4"));
				return question;

			}
		});
	}


}
