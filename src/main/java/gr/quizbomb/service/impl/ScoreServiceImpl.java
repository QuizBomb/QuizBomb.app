package gr.quizbomb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.quizbomb.model.Score;
import gr.quizbomb.repository.ScoreDAO;
import gr.quizbomb.service.ScoreService;
@Service
@Transactional
public class ScoreServiceImpl extends GenericServiceImpl<Score> implements ScoreService{

	@Autowired
	private ScoreDAO scoreDao;
	
	
	@Override
	public List<Score> getScores(Long studentId) {
		
		//return scoreDao.getStudentScores(studentId);
		
		return scoreDao.findByStudentId(studentId);
	}

	
}
