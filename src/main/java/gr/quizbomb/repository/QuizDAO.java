package gr.quizbomb.repository;

import java.util.List;

import gr.quizbomb.model.Quiz;
import gr.quizbomb.model.SClass;

public interface QuizDAO extends GenericRepository<Quiz>{
	
	public List<Quiz> findBySClass(SClass sClass);
	
}
