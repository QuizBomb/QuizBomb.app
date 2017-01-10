package gr.quizbomb.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.quizbomb.model.Professor;
import gr.quizbomb.service.ProfessorService;

@Service
@Transactional
public class ProfessorServiceImpl extends GenericServiceImpl<Professor> implements ProfessorService{
	

}
