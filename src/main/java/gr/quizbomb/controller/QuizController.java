package gr.quizbomb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import gr.quizbomb.model.helper.CreateQuizSimpler;
import gr.quizbomb.service.QuizService;

@Controller
public class QuizController {

	@Autowired
	private QuizService quizService;

	@RequestMapping(value = "/addQuiz", method = RequestMethod.POST)
	public String getProfessorHomePage(HttpSession session, @ModelAttribute("quiz2") CreateQuizSimpler quiz, @RequestParam Long sClassId, @RequestParam Long courseId) {
		
		quizService.createNewQuiz(quiz, sClassId, courseId);
		
		//quizService.createNewQuiz(quiz, sClassId, courseId);

		/*
		quiz.getQuestions().forEach(item->{
			if(item.isSelected()){
				System.out.println(item.getQuestion().getText());
			}
		});
		*/
		System.out.println(quiz.getQuestions().size());
	
		
		
		return "redirect:/professor";
	}	
}
