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

import edu.mum.domain.CashAccount;
import edu.mum.domain.Client;
import edu.mum.service.ClientService;

@Controller
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping("")
	public String list(Model model) {
		model.addAttribute("clients", clientService.findAll());
		return "clients";
	}

	
	@RequestMapping("/{id}")
	public String getClientById(@PathVariable("id") Integer id, Model model) {

 		Client client = clientService.findOne(id);
		model.addAttribute("client", client);
		return "client";
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewClientForm(@ModelAttribute("newClient") CashAccount newClient) {
	   return "addClient";
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewStockForm(@ModelAttribute("newClient") @Valid Client clienttoBeAdded, BindingResult result) {
		if(result.hasErrors()) {
			return "addClient";
		}

 		try {
 			clientService.save(clienttoBeAdded);
		} catch (Exception up) {
	      System.out.println("Transaction Failed!!!");
 
		}
		
	   	return "redirect:/clients";
	}

	
}
