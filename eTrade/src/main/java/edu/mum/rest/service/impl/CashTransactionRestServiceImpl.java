package edu.mum.rest.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.mum.domain.CashTransaction;
import edu.mum.rest.RemoteApi;
import edu.mum.rest.service.CashTransactionRestService;

@Component
public class CashTransactionRestServiceImpl implements CashTransactionRestService {

	@Autowired
	RemoteApi remoteApi;
	
	public List<CashTransaction> findAll() {
		
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		return Arrays.asList(restTemplate.exchange("http://localhost:8080/eTradeREST/cashTransactions/", HttpMethod.GET, remoteApi.getHttpEntity(), CashTransaction[].class).getBody());
 	}

	public CashTransaction findOne(Integer index) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
 		return (restTemplate.exchange("http://localhost:8080/eTradeREST/cashTransactions/"+ index, HttpMethod.GET, remoteApi.getHttpEntity(), CashTransaction.class).getBody());
	}

	public CashTransaction save(CashTransaction cashTransaction) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		HttpEntity<CashTransaction> httpEntity = new HttpEntity<CashTransaction>(cashTransaction, remoteApi.getHttpHeaders());
		restTemplate.postForObject("http://localhost:8080/eTradeREST/cashTransactions/add/", httpEntity, CashTransaction.class);
		return null;
	}

}
