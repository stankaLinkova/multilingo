package sk.upjs.paz1c.multilingo.persistent;

import java.util.List;

import sk.upjs.paz1c.multilingo.entities.Test;

public interface TestDao {

	List<Test> getAll();

	Test save(Test test);

	void delete(long id);
}
