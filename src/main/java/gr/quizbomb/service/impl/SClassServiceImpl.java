package gr.quizbomb.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.quizbomb.model.SClass;
import gr.quizbomb.service.SClassService;

@Service
@Transactional
public class SClassServiceImpl extends GenericServiceImpl<SClass> implements SClassService{

	
}
