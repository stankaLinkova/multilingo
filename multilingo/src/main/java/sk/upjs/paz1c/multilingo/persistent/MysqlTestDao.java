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

import sk.upjs.paz1c.multilingo.entities.Test;

public class MysqlTestDao implements TestDao {
	
	private JdbcTemplate jdbcTemplate;
	

	public MysqlTestDao(JdbcTemplate jdbcTemplate2) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Test> getAll() {
		String sql = "SELECT idTest, created_by, created_date, number_of_questions, language,  "
				+ " level, information, School_idSchool  "
				+ "FROM Test";

		return jdbcTemplate.query(sql, new RowMapper<Test>() {

			public Test mapRow(ResultSet rs, int rowNum) throws SQLException {
				Test test = new Test();
				test.setId(rs.getLong("id"));
				test.setCreatedBy(rs.getString("created_by"));
				
				Timestamp timestamp = rs.getTimestamp("created_date");
				if (timestamp != null) {
					test.setCreatedDate(timestamp.toLocalDateTime().toLocalDate());
				}
				
				test.setNumberOfQuestions(rs.getInt("number_of_questions"));
				test.setLanguage(rs.getString("language"));
				test.setLevel(rs.getString("level"));
				test.setInformation(rs.getString("information"));
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
					"level", "information", "School_idSchool");
			Map<String,Object> values = new HashMap<String, Object>();
			values.put("created_by",test.getCreatedBy());
			values.put("cretaed_date",test.getCreatedDate());
			values.put("number_of_questions", test.getNumberOfQuestions());
			values.put("langauge", test.getLanguage());
			values.put("level", test.getLevel());
			values.put("information", test.getInformation());
			values.put("School_idSchool", test.getIdSchool());
			Long id = simpleJdbcInsert.executeAndReturnKey(values).longValue();
			test.setId(id);
		} else { 
			String sql = "UPDATE Test SET "
					+ "created_by = ?, cretaed_date = ?, number_of_questions = ?, language = ?, "
					+ "level = ?,  information = ?, School_idSchool = ? "
					+ "WHERE idTest = ?";
			jdbcTemplate.update(sql, test.getCreatedBy(), test.getCreatedDate(),
					test.getNumberOfQuestions(), test.getLanguage(),
					test.getLevel(), test.getInformation(),
					test.getIdSchool(), test.getId());
		}
		return test;
		
	}

	public void delete(long id) {
		String sql = "DELETE FROM Test WHERE id = " + id;
		jdbcTemplate.update(sql);
		
	}


}
