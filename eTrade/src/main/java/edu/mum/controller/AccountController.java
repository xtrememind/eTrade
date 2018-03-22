package edu.mum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.domain.Client;
import edu.mum.domain.PortfolioBalance;
import edu.mum.domain.User;
import edu.mum.service.ClientService;
import edu.mum.service.UserService;

@Controller
@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ClientService clientService;
	
	
	@RequestMapping("")
	public String list(Model model) {
		model.addAttribute("customers", userService.findAll());
		return "account";
	}
	
	@RequestMapping("/ajaxDetails/{id}")
	public @ResponseBody List<PortfolioBalance> /*List<User>*/ listAjax(@PathVariable("id") Integer id) {
		//System.out.println("ajax details for "+id);
		Client client = clientService.findOne(id);
		List<PortfolioBalance> list = client.getPortfolio().getPortfolioBalances();
		return list;
	}

}
