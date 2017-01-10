package gr.quizbomb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gr.quizbomb.model.Professor;
import gr.quizbomb.service.ProfessorService;

@Controller
public class ProfessorUserController {
	
	@Autowired
	private ProfessorService professorService;
	
	/* This method will be implemented after a successful professor log in
	 */
	@RequestMapping(value = "/professor", method = RequestMethod.GET)
	public String getProfessorHomePage(HttpSession session, Model model) {
		
		Professor tempProfessor = professorService.findById(1);
		
		session.setAttribute("loggedUser", tempProfessor);
		
		return "professor";
	}	

}
