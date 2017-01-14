package gr.quizbomb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gr.quizbomb.model.User;
import gr.quizbomb.model.helper.Login;

@Controller
public class IndexController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getIndex(Model model) {
		
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginHomepage(HttpSession session, Model model) {
		
		if (session.getAttribute("loggedUser") == null){
		
			model.addAttribute("user", new Login());
			return "login";
		}else {
			
			User logged = (User) session.getAttribute("loggedUser");
			
			String role = logged.getRole();
			
			if (role.equals("student"))
				return "redirect:/student";	
			else if (role.equals("professor"))
				return "redirect:/professor";
			else if (role.equals("controller"))
				return "redirect:/controller";	
			else
				return "";
		}
	}
}
