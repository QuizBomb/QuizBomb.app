package gr.quizbomb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gr.quizbomb.model.Question;
import gr.quizbomb.service.QuestionService;


@Controller
public class ControllerUserController {

	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(value = "/controller", method = RequestMethod.GET)
	public  String getIndex(Model list) {
	
		
		list.addAttribute("questionsList", questionService.getNewQuestions());
		return "controller";
	}
	
	
	@RequestMapping("/questionRemove/{id}")
    public String remove(@PathVariable("id") long id){
		
		questionService.delete(id);
		return "redirect:/controller";
	}
	
	@RequestMapping("/questionApprove/{id}")
    public String approve(@PathVariable("id") long id ){

		Question x = questionService.findById(id);
		x.setApproved(true);
		questionService.update(x);	
		return "redirect:/controller";
	}
	
	
	
}
