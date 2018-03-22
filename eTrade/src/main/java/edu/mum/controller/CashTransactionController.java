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
import edu.mum.domain.CashTransaction;
import edu.mum.domain.Client;
import edu.mum.domain.Stock;
import edu.mum.service.CashAccountService;
import edu.mum.service.CashTransactionService;
import edu.mum.service.ClientService;

@Controller
@RequestMapping("/cashTransactions")
public class CashTransactionController {
	
	@Autowired
	private CashTransactionService cashTransactionService;
	@Autowired
	private ClientService  clientService;
	
	@Autowired
	private CashAccountService cashAccountService;

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


	@RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
	public String getAddNewCashTransactionForm(@PathVariable("id") Integer id
			,@ModelAttribute("newCashTransaction") CashTransaction newCashTransaction , Model model) {
		Client client = clientService.findOne(id);
		model.addAttribute("client", client);
		
	   return "addCashTransaction";
	}
	   
	@RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
	public String processAddNewStockForm(@ModelAttribute("newCashTransaction") @Valid CashTransaction cashTransactionToBeAdded, BindingResult result) {
		
		/*cashTransactionToBeAdded.getCashAccount().getId()*/
		CashAccount cash = cashAccountService.findOne(cashTransactionToBeAdded.getCashAccount().getId());
		
		cash.setBalance(cash.getBalance()+ cashTransactionToBeAdded.getAmount() );
		cashTransactionToBeAdded.setCashAccount(cash);
		
		 System.out.println(cashTransactionToBeAdded.getDescription());
		 System.out.println(cashTransactionToBeAdded.getCashAccount());
		 System.out.println(cashTransactionToBeAdded.getCashAccount().getId());
		 System.out.println("balance "+cashTransactionToBeAdded.getBalance());
		 System.out.println("amount" 
				 +cashTransactionToBeAdded.getAmount()) ;
		cashAccountService.update(cash);		
		
		if(result.hasErrors()) {
			
			return "addCashTransaction";
		}

 		try {
 			cashTransactionService.save(cashTransactionToBeAdded);
		} catch (Exception up) {
	      System.out.println("Transaction Failed!!!");
	      System.out.println(up.toString());
	      return "addCashTransaction";
 
		}
 		
	   	return "redirect:/clients";
	}
	
}
