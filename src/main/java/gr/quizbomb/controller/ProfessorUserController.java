package gr.quizbomb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gr.quizbomb.model.Answer;
import gr.quizbomb.model.Question;
import gr.quizbomb.model.Quiz;
import gr.quizbomb.model.helper.CreateQuizSimpler;
import gr.quizbomb.model.helper.QuestionForQuizSimpler;
import gr.quizbomb.service.QuestionService;

@Controller
public class ProfessorUserController {
 
 @Autowired
 private QuestionService questionService;
 
 
 /* This method will be implemented after a successful professor log in
  */
 @RequestMapping(value = "/professor", method = RequestMethod.GET)
 public String getProfessorHomePage(HttpSession session, Model model) {
    
  return "professor";
 } 
 
 @RequestMapping(value = "/createQuestion", method = RequestMethod.GET)
 public String getCreateQuestionPage(HttpSession session, Model model) {
      
  Question question = new Question();
  List<Answer> answers = new ArrayList<Answer>(4);
  
  question.setAnswer(answers);
 
  model.addAttribute("question", question);
  
  return "createQuestion";
 }
 
 @RequestMapping(value = "/createQuiz", method = RequestMethod.GET)
 public String getCreateQuizPage(HttpSession session, Model model) {
	 
	 CreateQuizSimpler quiz = new CreateQuizSimpler();
	 		
	 model.addAttribute("quiz2", quiz); 
      
  return "createQuiz";
 }
 
	@RequestMapping(value = "/createQuiz/loadQuestions/{sid}/{cid}", method = RequestMethod.GET)
	public String populateQuizQuestions(HttpSession session, Model model, @PathVariable("sid") Long sClassId,
			@PathVariable("cid") Long courseId) {
		
		model.addAttribute("sClassId", sClassId);
		model.addAttribute("courseId", courseId);
		
		Quiz quiz = new Quiz();
		
		CreateQuizSimpler quiz2 = new CreateQuizSimpler();
				
		List<Question> questions = questionService.getLoadQuestions(sClassId, courseId);
		
		List<QuestionForQuizSimpler> listQuestions = new ArrayList<QuestionForQuizSimpler>();
	
		
		for (Question temp : questions) {
			
			listQuestions.add(new QuestionForQuizSimpler(false, temp.getId(), temp.getText()));

		}
		
		quiz.setQuestions(questions);
		
		quiz2.setQuestions(listQuestions);
		
		model.addAttribute("quiz", quiz);
		model.addAttribute("quiz2", quiz2);
		//session.setAttribute("quiz", quiz);
				
		
		return "createQuiz";
	}

	
}