package gr.quizbomb.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
	private ScoreDAO scoreDAO;

	@Override
	public List<Score> getScoresFromThisYear() {
				
		Calendar cal = new GregorianCalendar();
	    cal.set(Calendar.DAY_OF_YEAR, 1);
	    
	    Date start = cal.getTime();
	    
	    cal.set(Calendar.DAY_OF_YEAR, 366);
	   
	    Date end = cal.getTime();
				
		return scoreDAO.findByCreatedAtBetweenOrderByQuiz(start, end);
	}
	
}
