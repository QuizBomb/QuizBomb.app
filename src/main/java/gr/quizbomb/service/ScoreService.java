package gr.quizbomb.service;

import java.util.List;


import gr.quizbomb.model.Score;

public interface ScoreService extends GenericService<Score>{

	//public List<Object> getScores(Long studentId);
	
	public List<Score> getScores(Long studentId);
}
