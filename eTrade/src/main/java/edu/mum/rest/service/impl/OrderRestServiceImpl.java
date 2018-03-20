package edu.mum.rest.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.mum.domain.Order;
import edu.mum.rest.RemoteApi;
import edu.mum.rest.service.OrderRestService;

@Component
public class OrderRestServiceImpl implements OrderRestService {

	@Autowired
	RemoteApi remoteApi;
	
	public List<Order> findAll() {
		
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		return Arrays.asList(restTemplate.exchange("http://localhost:8080/eTradeREST/orders/", HttpMethod.GET, remoteApi.getHttpEntity(), Order[].class).getBody());
 	}

	public Order findOne(Integer index) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
 		return (restTemplate.exchange("http://localhost:8080/eTradeREST/orders/"+ index, HttpMethod.GET, remoteApi.getHttpEntity(), Order.class).getBody());
	}

	public Order save(Order order) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		HttpEntity<Order> httpEntity = new HttpEntity<Order>(order, remoteApi.getHttpHeaders());
		restTemplate.postForObject("http://localhost:8080/eTradeREST/orders/add/", httpEntity, Order.class);
		return null;
	}

}
