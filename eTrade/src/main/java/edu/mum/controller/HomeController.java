package edu.mum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.service.ClientService;
import edu.mum.service.OrderService;
import edu.mum.service.StockService;
import edu.mum.service.UserService;
  
@Controller
public class HomeController {

	@Autowired
	UserService userService;
	
	@Autowired
	StockService stockService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	ClientService customerService;
 
	@RequestMapping({"/","/index"})
	public String welcome(Model model) {
		
		int numberOfUsers = userService.findAll().size();
		int numberOfStocks = stockService.findAll().size();
		int numberOfOrders = 0;//orderService.findAll().size();
		int numberOfCustomers =  customerService.findAll().size();
		
		model.addAttribute("numberOfUsers", numberOfUsers);
		model.addAttribute("numberOfStocks", numberOfStocks);
		model.addAttribute("numberOfOrders", numberOfOrders);
		model.addAttribute("numberOfCustomers", numberOfCustomers);
		
		return "index";
	}
	
	@RequestMapping("/access403")
	public String access403() {
		return "notAuthorized";
	}
 
}
