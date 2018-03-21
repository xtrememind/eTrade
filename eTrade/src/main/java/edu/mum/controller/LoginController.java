package edu.mum.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
 
import edu.mum.domain.UserCredentials;
import edu.mum.service.UserCredentialsService;

@Controller
@SessionAttributes("user")
public class LoginController {

	@Autowired
	UserCredentialsService credentialsService;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
 		return "login";
	}
 
	
	@RequestMapping(value="/postLogin", method = RequestMethod.POST)
	public String PostLogin(UserCredentials credentials, Model model,HttpServletRequest req, HttpServletResponse resp) {
		 
		
		UserCredentials validCredentials = credentialsService.findOne(credentials.getUserName());
		
		if (validCredentials == null || !validCredentials.getPassword().equals(credentials.getPassword()))
		{
			model.addAttribute("error", "error") ;
			return  "login";
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("userId",validCredentials.getUser().getId());
		session.setAttribute("fullName",validCredentials.getUser().getFirstName()+" "+validCredentials.getUser().getLastName());
        String remember = req.getParameter("remember");
        if(remember!=null && remember.equals("on")){
            Cookie cookie = new Cookie("userName",req.getParameter("userName"));
            cookie.setMaxAge(3600*30);
            resp.addCookie(cookie);
        }else{
            for (Cookie cookie : req.getCookies()) {
                if(cookie.getName().equals("userName")) {
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                }
            }
        }
		model.addAttribute("user", validCredentials.getUser());
 		return "redirect:/index";
	}
 
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {
 
		model.addAttribute("error", "true");
		return "login";
 
	}
 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model,HttpServletRequest req) {
		//status.setComplete();
		req.getSession().invalidate();
 		return "redirect:/login";
 	}
}