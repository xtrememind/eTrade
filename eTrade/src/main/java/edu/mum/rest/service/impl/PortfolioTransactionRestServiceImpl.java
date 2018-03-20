package edu.mum.rest.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.mum.domain.PortfolioTransaction;
import edu.mum.rest.RemoteApi;
import edu.mum.rest.service.PortfolioTransactionRestService;

@Component
public class PortfolioTransactionRestServiceImpl implements PortfolioTransactionRestService {

	@Autowired
	RemoteApi remoteApi;
	
	public List<PortfolioTransaction> findAll() {
		
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		return Arrays.asList(restTemplate.exchange("http://localhost:8080/eTradeREST/portfolioTransactions/", HttpMethod.GET, remoteApi.getHttpEntity(), PortfolioTransaction[].class).getBody());
 	}

	public PortfolioTransaction findOne(Integer index) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
 		return (restTemplate.exchange("http://localhost:8080/eTradeREST/portfolioTransactions/"+ index, HttpMethod.GET, remoteApi.getHttpEntity(), PortfolioTransaction.class).getBody());
	}

	public PortfolioTransaction save(PortfolioTransaction portfolioTransaction) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		HttpEntity<PortfolioTransaction> httpEntity = new HttpEntity<PortfolioTransaction>(portfolioTransaction, remoteApi.getHttpHeaders());
		restTemplate.postForObject("http://localhost:8080/eTradeREST/portfolioTransactions/add/", httpEntity, PortfolioTransaction.class);
		return null;
	}

}
