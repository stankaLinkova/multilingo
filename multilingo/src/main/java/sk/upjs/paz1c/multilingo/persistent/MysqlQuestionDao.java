package sk.upjs.paz1c.multilingo.persistent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import sk.upjs.paz1c.multilingo.entities.Question;

public class MysqlQuestionDao implements QuestionDao {

	private JdbcTemplate jdbcTemplate;

	public MysqlQuestionDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Question> getAll() {

		String sql = "SELECT idQuestion, task, right_answer, wrong_answer_1, wrong_answer_2, wrong_answer_3, "
				+ "wrong_answer_4, Test_idTest " + "FROM Question";
		
		return jdbcTemplate.query(sql, new RowMapper<Question>() {

			public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
				Question question = new Question();
				question.setId(rs.getLong("idQuestion"));
				question.setTask(rs.getString("task"));
				question.setRightAnswer(rs.getString("right_answer"));
				question.setWrongAnswer1(rs.getString("wrong_answer_1"));
				question.setWrongAnswer2(rs.getString("wrong_answer_2"));
				question.setWrongAnswer3(rs.getString("wrong_answer_3"));
				question.setWrongAnswer4(rs.getString("wrong_answer_4"));
				question.setWrongAnswer1(rs.getString("wrong_answer_1"));
				question.setIdTest(rs.getLong("Test_idTest"));

				return question;
			}

		});

	}

	public Question save(Question question) {
		if (question == null)
			return null;
		if (question.getId() == null) {
			SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
			simpleJdbcInsert.withTableName("Question");
			simpleJdbcInsert.usingGeneratedKeyColumns("idQuestion");
			simpleJdbcInsert.usingColumns("task", "right_answer", "wrong_answer_1", "wrong_answer_2", "wrong_answer_3",
					"wrong_answer_4", "Test_idTest");
			Map<String, Object> values = new HashMap<String, Object>();
			values.put("task", question.getTask());
			values.put("right_answer", question.getRightAnswer());
			values.put("wrong_answer_1", question.getWrongAnswer1());
			values.put("wrong_answer_2", question.getWrongAnswer2());
			values.put("wrong_answer_3", question.getWrongAnswer3());
			values.put("wrong_answer_4", question.getWrongAnswer4());
			values.put("Test_idTest", question.getIdTest());
			Long id = simpleJdbcInsert.executeAndReturnKey(values).longValue();
			question.setId(id);
		} else {
			String sql = "UPDATE Question SET " + "task= ?, right_answer = ?, wrong_answer_1 = ?, wrong_answer_2 = ?, "
					+ "wrong_answer_3 = ?, wrong_answer_4 = ?, Test_idTest = ? " + "WHERE idQuestion = ?";
			jdbcTemplate.update(sql, question.getTask(), question.getRightAnswer(), question.getWrongAnswer1(),
					question.getWrongAnswer2(), question.getWrongAnswer3(), question.getWrongAnswer4(),
					question.getIdTest(), question.getId());
		}
		return question;
	}

	public void delete(long id) {
		String sql = "DELETE FROM Question WHERE idQuestion = " + id;
		jdbcTemplate.update(sql);

	}

}
