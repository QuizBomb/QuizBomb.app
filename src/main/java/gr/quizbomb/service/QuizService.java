package gr.quizbomb.service;

import java.util.List;

import gr.quizbomb.model.Quiz;
import gr.quizbomb.model.SClass;
import gr.quizbomb.model.helper.CreateQuizSimpler;

public interface QuizService extends GenericService<Quiz>{

	public void createNewQuiz(CreateQuizSimpler quiz, Long sClassId, Long courseId);
	
	public List<Quiz> getQuizes(SClass sclass);
}
