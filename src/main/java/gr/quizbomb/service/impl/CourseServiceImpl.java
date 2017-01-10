package gr.quizbomb.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.quizbomb.model.Course;
import gr.quizbomb.service.CourseService;

@Service
@Transactional
public class CourseServiceImpl extends GenericServiceImpl<Course> implements CourseService{

	
}
