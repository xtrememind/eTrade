package edu.mum.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

import edu.mum.domain.CashTransaction;
import edu.mum.domain.Client;
import edu.mum.domain.Order;
import edu.mum.domain.Stock;
import edu.mum.service.CashTransactionService;
import edu.mum.service.ClientService;
import edu.mum.service.OrderService;
import edu.mum.service.StockService;
import edu.mum.service.UserService;

@Controller
@RequestMapping("/orders") 
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private StockService stockService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private UserService userService;
 
 	@RequestMapping("")
	public String list(Model model) {
		model.addAttribute("orders", orderService.findAll());
		return "orders";
	}
	
 	@RequestMapping("/{id}")
	public String getOrderById(@PathVariable("id") Integer id, Model model) {

		Order order = orderService.findOne(id);
		model.addAttribute("order", order);
		return "order";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView getAddNewOrderForm(@ModelAttribute("newOrder") Order newOrder) {
        ModelAndView mav = new ModelAndView("addOrder");
        Map<Integer,String> stockMap = new HashMap<Integer,String>();
        for (Stock stock : stockService.findAll()) stockMap.put(stock.getId(),stock.getName());
        mav.addObject("stocks",stockMap);
        Map<Integer,String> clientMap = new HashMap<Integer,String>();
        for (Client client : clientService.findAll()) clientMap.put(client.getId(),client.getName());
		mav.addObject("clients", clientMap);
        return mav;
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewOrderForm(@ModelAttribute("newOrder") @Valid Order orderToBeAdded, BindingResult result ,Model model) {
		if(result.hasErrors()) {
			 //ModelAndView mav = new ModelAndView("addOrder");
		        Map<Integer,String> stockMap = new HashMap<Integer,String>();
		        for (Stock stock : stockService.findAll()) stockMap.put(stock.getId(),stock.getName());
		        model.addAttribute("stocks",stockMap);
		        Map<Integer,String> clientMap = new HashMap<Integer,String>();
		        for (Client client : clientService.findAll()) clientMap.put(client.getId(),client.getName());
		        model.addAttribute("clients", clientMap);
		        return "addOrder";
			//return "addOrder";
		}
		Client buyer = clientService.findOne(orderToBeAdded.getBuyerClient().getId());
		Client seller = clientService.findOne(orderToBeAdded.getSellerClient().getId());
		Stock stock = stockService.findOne(orderToBeAdded.getStock().getId());
		orderToBeAdded.setBuyerClient(buyer);
		orderToBeAdded.setSellerClient(seller);
		orderToBeAdded.setStock(stock);
		orderToBeAdded.setDate(new Date());
		orderToBeAdded.setBuyerBrokerFees(buyer.getPortfolio().getBrokerFees());
		orderToBeAdded.setBuyerMarketFees(buyer.getPortfolio().getMarketFees());
		orderToBeAdded.setBuyerOrderAmount(orderToBeAdded.getQuantity() * orderToBeAdded.getPrice());
		orderToBeAdded.setSellerBrokerFees(seller.getPortfolio().getBrokerFees());
		orderToBeAdded.setSellerMarketFees(seller.getPortfolio().getMarketFees());
		orderToBeAdded.setSellerOrderAmount(orderToBeAdded.getQuantity() * orderToBeAdded.getPrice());
		orderToBeAdded.setUser(userService.findOne(1));
		orderService.save(orderToBeAdded);

		
	   	return "redirect:/orders";
	}
	
   
}
