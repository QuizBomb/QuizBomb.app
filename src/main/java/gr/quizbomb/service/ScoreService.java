package gr.quizbomb.service;

import java.util.List;

import gr.quizbomb.model.Score;

public interface ScoreService extends GenericService<Score>{

	public List<Score> getScoresFromThisYear();

}
