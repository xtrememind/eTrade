package edu.mum.rest.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.mum.domain.PortfolioBalance;
import edu.mum.rest.RemoteApi;
import edu.mum.rest.service.PortfolioBalanceRestService;

@Component
public class PortfolioBalanceRestServiceImpl implements PortfolioBalanceRestService {

	@Autowired
	RemoteApi remoteApi;
	
	public List<PortfolioBalance> findAll() {
		
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		return Arrays.asList(restTemplate.exchange("http://localhost:8080/eTradeREST/portfolioBalances/", HttpMethod.GET, remoteApi.getHttpEntity(), PortfolioBalance[].class).getBody());
 	}

	public PortfolioBalance findOne(Integer index) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
 		return (restTemplate.exchange("http://localhost:8080/eTradeREST/portfolioBalances/"+ index, HttpMethod.GET, remoteApi.getHttpEntity(), PortfolioBalance.class).getBody());
	}

	public PortfolioBalance save(PortfolioBalance portfolioBalance) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		HttpEntity<PortfolioBalance> httpEntity = new HttpEntity<PortfolioBalance>(portfolioBalance, remoteApi.getHttpHeaders());
		restTemplate.postForObject("http://localhost:8080/eTradeREST/portfolioBalances/add/", httpEntity, PortfolioBalance.class);
		return null;
	}

}
