package gr.quizbomb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gr.quizbomb.model.Question;
import gr.quizbomb.model.Score;

public interface ScoreDAO extends GenericRepository<Score>{
	
	public List<Score> findByStudentId(Long sid);
	
	/*
	@Query("SELECT q.title, q.Sclass.value, q.Course.name, s.successrate FROM Quiz q, Score s"
	 		+ "WHERE q.id = s.Quiz.id "
			+ "AND s.Student.id = :s_id")
	  public List<Object> getStudentScores(@Param("s_id") Long studentId);
	*/
	
}
