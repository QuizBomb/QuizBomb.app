package gr.quizbomb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gr.quizbomb.model.Score;
import gr.quizbomb.model.helper.ScoreClassStatistics;
import gr.quizbomb.service.ScoreService;

@Controller
public class StatisticsController {
	
	@Autowired
	private ScoreService scoreService;
	
	@RequestMapping(value = "/statistics", method = RequestMethod.GET)
	public String getStatisticsPage(Model model) {
		
		List<Score> scores = scoreService.getScoresFromThisYear();
		
		List<ScoreClassStatistics> list = new ArrayList<ScoreClassStatistics>();
		
		ScoreClassStatistics a = new ScoreClassStatistics("Α' Γυμνασίου");
		
		ScoreClassStatistics b = new ScoreClassStatistics("Β' Γυμνασίου");
		
		ScoreClassStatistics c = new ScoreClassStatistics("Γ' Γυμνασίου");
		
		for (Score score: scores){
			
			if (score.getStudentQuiz().getsClass().getValue().equals("A")){
				
				a.setScore(score.getSuccessRate());
				a.setCount(a.getCount() + 1);
			} else if (score.getStudentQuiz().getsClass().getValue().equals("B")){
				
				b.setScore(score.getSuccessRate());
				b.setCount(a.getCount() + 1);
			} else if (score.getStudentQuiz().getsClass().getValue().equals("C")){
				
				c.setScore(score.getSuccessRate());
				c.setCount(a.getCount() + 1);
			}	
			
		}
		
		a.setScore(a.getScore() / a.getCount());
		b.setScore(b.getScore() / b.getCount());
		c.setScore(c.getScore() / c.getCount());
			
		list.add(a);
		list.add(b);
		list.add(c);
		
		model.addAttribute("classScores", list);
		return "statistics";
	}
}
