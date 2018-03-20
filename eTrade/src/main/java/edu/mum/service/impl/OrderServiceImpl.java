package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.Order;
import edu.mum.rest.service.OrderRestService;

@Service
@Transactional 
public class OrderServiceImpl implements edu.mum.service.OrderService {
	
	@Autowired
	private OrderRestService orderRestService;

 	
     public void save( Order order) {  		
  		orderRestService.save(order);
 	}
  	
    @Override
    	public void saveFull( Order order) {
   		orderRestService.save(order);
 	}
   	
	
	public List<Order> findAll() {
		return (List<Order>)orderRestService.findAll();
	}

 	@Override
	public Order findOne(Integer id) {
		 
		return orderRestService.findOne(id);
	}
 

}
