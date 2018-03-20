package edu.mum.rest.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.mum.domain.Client;
import edu.mum.rest.RemoteApi;
import edu.mum.rest.service.ClientRestService;

@Component
public class ClientRestServiceImpl implements ClientRestService {

	@Autowired
	RemoteApi remoteApi;
	
	public List<Client> findAll() {
		
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		return Arrays.asList(restTemplate.exchange("http://localhost:8080/eTradeREST/clients/", HttpMethod.GET, remoteApi.getHttpEntity(), Client[].class).getBody());
 	}

	public Client findOne(Integer index) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
 		return (restTemplate.exchange("http://localhost:8080/eTradeREST/clients/"+ index, HttpMethod.GET, remoteApi.getHttpEntity(), Client.class).getBody());
	}

	public Client save(Client client) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		HttpEntity<Client> httpEntity = new HttpEntity<Client>(client, remoteApi.getHttpHeaders());
		restTemplate.postForObject("http://localhost:8080/eTradeREST/clients/add/", httpEntity, Client.class);
		return null;
	}

}
