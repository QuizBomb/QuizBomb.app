package gr.quizbomb.repository;

import java.util.Date;
import java.util.List;

import gr.quizbomb.model.Score;

public interface ScoreDAO extends GenericRepository<Score>{
	
	public List<Score> findByCreatedAtBetweenOrderByQuiz(Date start, Date end);
	
}
