package gr.quizbomb.service;

import java.util.List;


import gr.quizbomb.model.Question;

public interface QuestionService extends GenericService<Question>{

	public List<Question> getNewQuestions();
}
