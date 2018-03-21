package edu.mum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.Client;
import edu.mum.service.ClientService;

@Controller
@RequestMapping({"/clients"})
public class CustomerController {
	
	
	@Autowired
	private ClientService  clientService;
	
	@RequestMapping("")
	public String welcome(Model model) {
		
		model.addAttribute("clients", clientService.findAll());
		return "customer";
	}
	
  	@RequestMapping("/{id}")
	public String getUserById(@PathVariable("id") Integer id,Model model) {
		Client client = clientService.findOne(id);
		model.addAttribute("client", client);
 		return "client";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewUserForm(@ModelAttribute("newClient") Client newClient) {
	   return "addClient";
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewUserForm(@ModelAttribute("newClient") @Valid Client clientToBeAdded, BindingResult result) {
 
		if(result.hasErrors()) {
			return "addClient";
		}
		//  Error caught by ControllerAdvice IF no authorization...
		clientService.save(clientToBeAdded);
	   	return "redirect:/clients";
	}
}
