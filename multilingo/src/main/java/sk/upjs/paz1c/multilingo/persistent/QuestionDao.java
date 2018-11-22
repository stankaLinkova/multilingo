package sk.upjs.paz1c.multilingo.persistent;

import java.util.List;

import sk.upjs.paz1c.multilingo.entities.Question;


public interface QuestionDao {

	List<Question> getAll();
	
	Question save(Question question);
	
	void delete(long id);
}
