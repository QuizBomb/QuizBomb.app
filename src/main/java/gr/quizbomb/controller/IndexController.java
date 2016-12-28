package gr.quizbomb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gr.quizbomb.service.DummyService;

@Controller
public class IndexController {
	
	@Autowired
	private DummyService dummyService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getIndex(Model model) {
		
		model.addAttribute("dummy", dummyService.findById(0));
		return "index";
	}

}
