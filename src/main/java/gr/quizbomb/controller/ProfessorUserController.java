package gr.quizbomb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gr.quizbomb.model.Answer;
import gr.quizbomb.model.Professor;
import gr.quizbomb.model.Question;
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
	
	@RequestMapping(value = "/createQuestion", method = RequestMethod.GET)
	public String getCreateQuestionPage(HttpSession session, Model model) {
		
		Professor tempProfessor = professorService.findById(1);
		
		session.setAttribute("loggedUser", tempProfessor);
		
		Question question = new Question();
		List<Answer> answers = new ArrayList<Answer>(4);
		
		question.setAnswer(answers);
	
		model.addAttribute("question", question);
		
		return "createQuestion";
	}

}
