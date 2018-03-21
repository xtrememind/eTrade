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

import edu.mum.domain.CashTransaction;
import edu.mum.domain.Stock;
import edu.mum.service.CashTransactionService;

@Controller
@RequestMapping("/cashTransactions")
public class CashTransactionController {
	
	@Autowired
	private CashTransactionService cashTransactionService;
	

 	@RequestMapping("")
	public String list(Model model) {
		model.addAttribute("cashTransactions", cashTransactionService.findAll());
		return "cashTransactions";
	}
 	
 	@RequestMapping("/{id}")
	public String getCashTransactionById(@PathVariable("id") Integer id, Model model) {

 		CashTransaction cashTransaction = cashTransactionService.findOne(id);
		model.addAttribute("cashTransaction", cashTransaction);
		return "cashTransaction";
	}


	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewCashTransactionForm(@ModelAttribute("newCashTransaction") CashTransaction newCashTransaction) {
	   return "addCashTransaction";
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewStockForm(@ModelAttribute("newCashTransaction") @Valid CashTransaction cashTransactionToBeAdded, BindingResult result) {
		if(result.hasErrors()) {
			return "addCashTransaction";
		}

 		try {
 			cashTransactionService.save(cashTransactionToBeAdded);
		} catch (Exception up) {
	      System.out.println("Transaction Failed!!!");
 
		}
		
	   	return "redirect:/cashTransactions";
	}
	
}
