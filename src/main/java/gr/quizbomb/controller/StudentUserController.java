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

import gr.quizbomb.model.Quiz;
import gr.quizbomb.model.Score;
import gr.quizbomb.model.Student;
import gr.quizbomb.model.helper.QuizStudent;
import gr.quizbomb.service.QuizService;
import gr.quizbomb.service.ScoreService;
import gr.quizbomb.service.StudentService;

@Controller
public class StudentUserController {
	
	@Autowired
	private QuizService quizService;

	@Autowired
	private ScoreService scoreService;

	@Autowired
	private StudentService studentService;

	/*
	 * This method will be implemented after a successful professor log in
	 */
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String getStudentHomePage(HttpSession session, Model model) {

		Student s = (Student) session.getAttribute("loggedUser");
		
		if (s != null){
					
			List<Quiz> quizes = quizService.getQuizes(s.getsClass());
			
			List<QuizStudent> finalList = new ArrayList<QuizStudent>();
			
			for (int i=0; i<quizes.size(); i++){
								
				Quiz temp = quizes.get(i);
				
				QuizStudent quiz = new QuizStudent(temp.getId(), temp.getTitle(), temp.getCourse().getName(), temp.getQuestions());
				
				for (int j=0; j<s.getScore().size(); j++){
															
					if (s.getScore().get(j).getStudentQuiz().getId() == temp.getId()){
													
						quiz.setSuccessrate(s.getScore().get(j).getSuccessRate());
				  }
						
				}
				
				finalList.add(quiz);
				
			}
		
			model.addAttribute("quizes", finalList);
		}
		
		return "student";
	}

}