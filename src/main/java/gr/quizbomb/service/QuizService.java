package gr.quizbomb.service;

import gr.quizbomb.model.Quiz;
import gr.quizbomb.model.helper.CreateQuizSimpler;

public interface QuizService extends GenericService<Quiz>{

	public void createNewQuiz(CreateQuizSimpler quiz, Long sClassId, Long courseId);
}
