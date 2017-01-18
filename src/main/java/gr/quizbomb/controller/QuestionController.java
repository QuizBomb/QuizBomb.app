package gr.quizbomb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import gr.quizbomb.model.Question;
import gr.quizbomb.service.QuestionService;

@Controller
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;

	@RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
	public String getProfessorHomePage(HttpSession session, @ModelAttribute("question") Question question, @RequestParam Long sClassId, @RequestParam Long courseId) {
		
		questionService.createNewQuestion(question, sClassId, courseId);
		
		session.setAttribute("questionAddedSuccessfully", true);
		
		return "redirect:/professor";
	}	
}
