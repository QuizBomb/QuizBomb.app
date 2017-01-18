package gr.quizbomb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.quizbomb.model.Course;
import gr.quizbomb.model.Question;
import gr.quizbomb.model.Quiz;
import gr.quizbomb.model.SClass;
import gr.quizbomb.model.helper.CreateQuizSimpler;
import gr.quizbomb.model.helper.QuestionForQuizSimpler;
import gr.quizbomb.service.CourseService;
import gr.quizbomb.service.QuestionService;
import gr.quizbomb.service.QuizService;
import gr.quizbomb.service.SClassService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class QuizServiceImpl extends GenericServiceImpl<Quiz> implements QuizService{

	
	@Autowired
	private SClassService sClassService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private QuestionService questionService;
	

	@Override
	public void createNewQuiz(CreateQuizSimpler quiz, Long sClassId, Long courseId) {
		
		Quiz newQuiz = new Quiz();
		
		SClass sClass = sClassService.findById(sClassId);
		
		Course course = courseService.findById(courseId);
		
		newQuiz.setTitle(quiz.getTitle());
		newQuiz.setCourse(course);
		newQuiz.setsClass(sClass);
		
		List<Question> selectedQuestions = new ArrayList<Question>();
		
		for (QuestionForQuizSimpler q : quiz.getQuestions()){
			
			if (q.isSelected()){
				
				Question tempQuestion = questionService.findById(q.getId());
				
				selectedQuestions.add(tempQuestion);
			}
			
		}
		
		newQuiz.setQuestions(selectedQuestions);
		
		this.create(newQuiz);
	}	
}
