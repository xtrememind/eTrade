package edu.mum.rest.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.mum.domain.CashAccount;
import edu.mum.domain.CashTransaction;
import edu.mum.rest.RemoteApi;
import edu.mum.rest.service.CashAccountRestService;

@Component
public class CashAccountRestServiceImpl implements CashAccountRestService {

	@Autowired
	RemoteApi remoteApi;
	
	public List<CashAccount> findAll() {
		
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		return Arrays.asList(restTemplate.exchange("http://localhost:8080/eTradeREST/cashAccounts/", HttpMethod.GET, remoteApi.getHttpEntity(), CashAccount[].class).getBody());
 	}

	public CashAccount findOne(Integer index) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
 		return (restTemplate.exchange("http://localhost:8080/eTradeREST/cashAccounts/"+ index, HttpMethod.GET, remoteApi.getHttpEntity(), CashAccount.class).getBody());
	}

	public CashAccount save(CashAccount cashAccount) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		HttpEntity<CashAccount> httpEntity = new HttpEntity<CashAccount>(cashAccount, remoteApi.getHttpHeaders());
		restTemplate.postForObject("http://localhost:8080/eTradeREST/cashAccounts/add/", httpEntity, CashAccount.class);
		return null;
	}
	
	@Override
	public CashAccount update(CashAccount cashAccount) {
		
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		HttpEntity<CashAccount> httpEntity = new HttpEntity<CashAccount>(cashAccount, remoteApi.getHttpHeaders());
		restTemplate.postForObject("http://localhost:8080/eTradeREST/cashAccounts/update/", httpEntity, CashAccount.class);
		return null;
	}

}
