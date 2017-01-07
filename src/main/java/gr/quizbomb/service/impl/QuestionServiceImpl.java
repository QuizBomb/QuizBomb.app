package gr.quizbomb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.quizbomb.model.Question;
import gr.quizbomb.repository.QuestionDAO;

import gr.quizbomb.service.QuestionService;
@Service
@Transactional
public class QuestionServiceImpl extends GenericServiceImpl<Question> implements QuestionService{

	@Autowired
	private QuestionDAO questionDao;
	
	@Override
	public List<Question> getNewQuestions() {
		
		return questionDao.findByApproved(false);
	}

	
}
