package edu.mum.service;

import java.util.List;

import edu.mum.domain.Order;
 
public interface OrderService {

	public void save(Order order);
	public List<Order> findAll();
	public Order findOne(Integer id);
 	public void saveFull( Order order);		

}
