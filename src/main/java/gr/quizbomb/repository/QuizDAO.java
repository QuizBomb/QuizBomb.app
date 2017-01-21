package gr.quizbomb.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import gr.quizbomb.model.Quiz;
import gr.quizbomb.model.SClass;
import gr.quizbomb.model.Score;

public interface QuizDAO extends GenericRepository<Quiz>{
	
	public List<Quiz> findBySClass(SClass sClass);
	
	/*
	@Query("SELECT q.title FROM Quiz q, Student s"
	 		+ "WHERE q.Sclass.id = s.SClass.id "
			+ "AND s.Student.id = :s_id")
	  public List<Quiz> getSClassQuizzes(@Param("s_id") Long studentId);
	*/  
}
