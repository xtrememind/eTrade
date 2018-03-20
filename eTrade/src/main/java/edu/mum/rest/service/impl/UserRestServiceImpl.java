package edu.mum.rest.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.mum.domain.User;
import edu.mum.rest.RemoteApi;
import edu.mum.rest.service.UserRestService;

@Component
public class UserRestServiceImpl implements UserRestService {

	@Autowired
	RemoteApi remoteApi;
	
	public List<User> findAll() {
		
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		return Arrays.asList(restTemplate.exchange("http://localhost:8080/eTradeREST/users/", HttpMethod.GET, remoteApi.getHttpEntity(), User[].class).getBody());
 	}

	public User findOne(Integer index) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
 		return (restTemplate.exchange("http://localhost:8080/eTradeREST/users/"+ index, HttpMethod.GET, remoteApi.getHttpEntity(), User.class).getBody());
	}

	public User save(User member) {
		RestTemplate restTemplate = remoteApi.getRestTemplate();
		HttpEntity<User> httpEntity = new HttpEntity<User>(member, remoteApi.getHttpHeaders());
		restTemplate.postForObject("http://localhost:8080/eTradeREST/users/add/", httpEntity, User.class);
		return null;
	}

}
