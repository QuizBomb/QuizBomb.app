package gr.quizbomb.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import gr.quizbomb.model.Answer;
import gr.quizbomb.model.Question;
import gr.quizbomb.model.Quiz;
import gr.quizbomb.model.Score;
import gr.quizbomb.model.Student;
import gr.quizbomb.model.User;
import gr.quizbomb.model.helper.CreateQuizSimpler;
import gr.quizbomb.service.QuizService;
import gr.quizbomb.service.ScoreService;
import gr.quizbomb.service.UserService;

@Controller
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	@Autowired
	private ScoreService scoreService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/addQuiz", method = RequestMethod.POST)
	public String getProfessorHomePage(HttpSession session, @ModelAttribute("quiz2") CreateQuizSimpler quiz,
			@RequestParam Long sClassId, @RequestParam Long courseId) {

		quizService.createNewQuiz(quiz, sClassId, courseId);

		return "redirect:/professor";
	}

	@RequestMapping(value = "/quiz/{id}", method = RequestMethod.GET)
	public String getQuiz(@PathVariable("id") Long id, Model list) {

		Quiz q = quizService.findById(id);
		
		Quiz qu = new Quiz();
		List<Question> qList = new ArrayList<Question>();
		
		for (Question quest : q.getQuestions()) {
			
			Question que = new Question();
			
			List<Answer> answerList = new ArrayList<Answer>();
			
			for (Answer ans : quest.getAnswer()) {
				
				Answer tempAnswer = new Answer(ans.getId(), false);
				answerList.add(tempAnswer);
				if (ans.isCorrect() == true) {
					ans.setCorrect(false);
				}
				
			}
			
			que.setAnswer(answerList);
			qList.add(que);
		}
		
		qu.setQuestions(qList);
		list.addAttribute("quizList", q);
		
		list.addAttribute("quiz", qu);
		
		return "takeQuiz";
	}
	
	@RequestMapping(value = "/submitQuiz", method = RequestMethod.POST)
	public String submitQuiz(HttpSession session, @ModelAttribute("quiz") Quiz quiz){
		
		Student s = (Student) session.getAttribute("loggedUser");
		
		float value = 0f;
		
		Quiz x = quizService.findById(quiz.getId());
		
		for (int i=0;i< quiz.getQuestions().size();i++) {
			
			for (int j=0;j<4; j++) {
				if ( (quiz.getQuestions().get(i).getAnswer().get(j).isCorrect() == true) && (quiz.getQuestions().get(i).getAnswer().get(j).isCorrect() == x.getQuestions().get(i).getAnswer().get(j).isCorrect()) ) {
					value = value + 20/ quiz.getQuestions().size();
				
				}
			}
						
		}
		if(value == 0f)
		{
			value = 0.2f;
		}
		
		Score score = new Score(quiz, s, value);
		scoreService.create(score);
		
		//Workaround to solve HttpSession issue
		session.removeAttribute("loggedUser");
		User logged = userService.findById(s.getId());
		session.setAttribute("loggedUser", logged);
		
		return "redirect:/student";
	}
	
}
