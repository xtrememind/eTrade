package edu.mum.rest.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.mum.domain.Portfolio;
import edu.mum.rest.RemoteApi;
import edu.mum.rest.service.PortfolioRestService;

@Component
public class PortfolioRestServiceImpl implements PortfolioRestService {

	@Autowired
	RemoteApi remoteApi;
	
	public List<Portfolio> findAll() {
		
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		return Arrays.asList(restTemplate.exchange("http://localhost:8080/eTradeREST/portfolios/", HttpMethod.GET, remoteApi.getHttpEntity(), Portfolio[].class).getBody());
 	}

	public Portfolio findOne(Integer index) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
 		return (restTemplate.exchange("http://localhost:8080/eTradeREST/portfolios/"+ index, HttpMethod.GET, remoteApi.getHttpEntity(), Portfolio.class).getBody());
	}

	public Portfolio save(Portfolio portfolio) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		HttpEntity<Portfolio> httpEntity = new HttpEntity<Portfolio>(portfolio, remoteApi.getHttpHeaders());
		restTemplate.postForObject("http://localhost:8080/eTradeREST/portfolios/add/", httpEntity, Portfolio.class);
		return null;
	}

}
