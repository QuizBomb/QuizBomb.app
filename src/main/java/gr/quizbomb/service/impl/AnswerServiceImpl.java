package gr.quizbomb.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.quizbomb.model.Answer;
import gr.quizbomb.service.AnswerService;

@Service
@Transactional
public class AnswerServiceImpl extends GenericServiceImpl<Answer> implements AnswerService{

	
}
