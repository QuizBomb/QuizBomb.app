package gr.quizbomb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gr.quizbomb.model.User;
import gr.quizbomb.model.dto.Login;
import gr.quizbomb.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/performLogin", method = RequestMethod.POST)
	public String getProfessorHomePage(HttpSession session, @ModelAttribute("user") Login login) {
		
		User logged = userService.findUserByUsernameAndPassword(login.getUsername(), login.getPassword());
		
		if (logged == null){
			
			session.setAttribute("failedLogin", true);
			
			return "redirect:/login";
		}else{
			
			session.setAttribute("failedLogin", false);
			
			session.setAttribute("loggedUser", logged);
			
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
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		
		session.removeAttribute("loggedUser");
		
		return "redirect:/";
	}
}
