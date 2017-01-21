package gr.quizbomb.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.quizbomb.model.Student;
import gr.quizbomb.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl extends GenericServiceImpl<Student> implements StudentService{

	
}
