package edu.mum.rest.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.mum.domain.Stock;
import edu.mum.rest.RemoteApi;
import edu.mum.rest.service.StockRestService;

@Component
public class StockRestServiceImpl implements StockRestService {

	@Autowired
	RemoteApi remoteApi;
	
	public List<Stock> findAll() {
		
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		return Arrays.asList(restTemplate.exchange("http://localhost:8080/eTradeREST/stocks/", HttpMethod.GET, remoteApi.getHttpEntity(), Stock[].class).getBody());
 	}

	public Stock findOne(Integer index) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
 		return (restTemplate.exchange("http://localhost:8080/eTradeREST/stocks/"+ index, HttpMethod.GET, remoteApi.getHttpEntity(), Stock.class).getBody());
	}

	public Stock save(Stock stock) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		HttpEntity<Stock> httpEntity = new HttpEntity<Stock>(stock, remoteApi.getHttpHeaders());
		restTemplate.postForObject("http://localhost:8080/eTradeREST/stocks/add/", httpEntity, Stock.class);
		return null;
	}

}
