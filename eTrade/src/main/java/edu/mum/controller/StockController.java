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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.domain.Stock;
import edu.mum.service.StockService;

@Controller
@RequestMapping("/stocks")
public class StockController {
	
	@Autowired
	private StockService stockService;
 
 	@RequestMapping("")
	public String list(Model model) {
		model.addAttribute("stocks", stockService.findAll());
		return "stocks";
	}
	
 	@RequestMapping("/{id}")
	public String getStockById(@PathVariable("id") Integer id, Model model) {

		Stock stock = stockService.findOne(id);
		model.addAttribute("stock", stock);
		return "stock";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewStockForm(@ModelAttribute("newStock") Stock newStock) {
	   return "addStock";
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewStockForm(@ModelAttribute("newStock") @Valid Stock stockToBeAdded, BindingResult result) {
		if(result.hasErrors()) {
			return "addStock";
		}

 		try {
			stockService.save(stockToBeAdded);
		} catch (Exception up) {
	      System.out.println("Transaction Failed!!!");
 
		}
		
	   	return "redirect:/stocks";
	}
	
   
}
