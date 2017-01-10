package gr.quizbomb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.quizbomb.model.Answer;
import gr.quizbomb.model.Course;
import gr.quizbomb.model.Question;
import gr.quizbomb.model.SClass;
import gr.quizbomb.repository.QuestionDAO;
import gr.quizbomb.service.AnswerService;
import gr.quizbomb.service.CourseService;
import gr.quizbomb.service.QuestionService;
import gr.quizbomb.service.SClassService;
@Service
@Transactional
public class QuestionServiceImpl extends GenericServiceImpl<Question> implements QuestionService{

	@Autowired
	private QuestionDAO questionDao;
	
	@Autowired
	private SClassService sClassService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private AnswerService answerService;
	
	@Override
	public List<Question> getNewQuestions() {
		
		return questionDao.findByApproved(false);
	}

	@Override
	public void createNewQuestion(Question question, Long sClassId, Long courseId) {
		
		SClass sClass = sClassService.findById(sClassId);
		
		Course course = courseService.findById(courseId);
		
		question.setCourse(course);
		question.setsClass(sClass);
		
		question = this.create(question);
		
		for (int i=0; i<question.getAnswer().size(); i++){
			
			Answer answer = question.getAnswer().get(i);
			answer.setQuestion(question);
			
			answerService.create(answer);
		}
		
	}

	
}
