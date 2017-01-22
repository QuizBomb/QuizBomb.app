package gr.quizbomb.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.quizbomb.model.Score;
import gr.quizbomb.service.ScoreService;

@Service
@Transactional
public class ScoreServiceImpl extends GenericServiceImpl<Score> implements ScoreService{

	
}
