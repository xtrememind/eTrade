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
import edu.mum.service.CashAccountService;

@Controller
@RequestMapping("/cashAccounts")
public class CashAccountController {
	

	@Autowired
	private CashAccountService cashAccountService;
 
 	@RequestMapping("")
	public String list(Model model) {
		model.addAttribute("cashAccounts", cashAccountService.findAll());
		return "cashAccounts";
	}
	
 	@RequestMapping("/{id}")
	public String getCashAccountById(@PathVariable("id") Integer id, Model model) {

 		CashAccount cashAccount = cashAccountService.findOne(id);
		model.addAttribute("cashAccount", cashAccount);
		return "cashAccount";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewCashAccountForm(@ModelAttribute("newCashAccount") CashAccount newCashAccount) {
	   return "addCashAccount";
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewStockForm(@ModelAttribute("newCashAccount") @Valid CashAccount cashAccountoBeAdded, BindingResult result) {
		if(result.hasErrors()) {
			return "addCashAccount";
		}

 		try {
 			cashAccountService.save(cashAccountoBeAdded);
		} catch (Exception up) {
	      System.out.println("Transaction Failed!!!");
 
		}
		
	   	return "redirect:/cashAccounts";
	}

}
