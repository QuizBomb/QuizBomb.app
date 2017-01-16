package gr.quizbomb.service;

import java.util.List;
import gr.quizbomb.model.Quiz;
import gr.quizbomb.model.helper.CreateQuizSimpler;

public interface QuizService extends GenericService<Quiz>{
	
	public void createNewQuiz(Quiz quiz, Long sClassId, Long courseId);

	public void createNewQuiz(CreateQuizSimpler quiz, Long sClassId, Long courseId);
}
