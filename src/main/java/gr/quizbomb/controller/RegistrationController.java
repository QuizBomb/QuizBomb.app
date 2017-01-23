package gr.quizbomb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gr.quizbomb.model.Student;
import gr.quizbomb.model.helper.Register;
import gr.quizbomb.service.SClassService;
import gr.quizbomb.service.StudentService;

@Controller
public class RegistrationController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private SClassService sClassService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegistrationPage(Model model) {
		
		model.addAttribute("student", new Register());
		
		return "register";		
	}
	
	@RequestMapping(value = "/performRegistration", method = RequestMethod.POST)
	public String performRegistration(HttpSession session, Model model, @ModelAttribute("student") Register student){
	
		Student newStudent = new Student(student.getFullName(), student.getUsername(), student.getEmail(), student.getPassword(), sClassService.findById(student.getsClassId()));
		newStudent = studentService.create(newStudent);
		
		return "redirect:/login";	
	}
}
