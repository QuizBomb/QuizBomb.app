package gr.quizbomb.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import gr.quizbomb.model.DummyEntity;
import gr.quizbomb.service.DummyService;

@Service
@Transactional
public class DummyServiceImpl extends GenericServiceImpl<DummyEntity> implements DummyService{
	

}
