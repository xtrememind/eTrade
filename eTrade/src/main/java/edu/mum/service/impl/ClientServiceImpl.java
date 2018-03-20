package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.Client;
import edu.mum.rest.service.ClientRestService;
import edu.mum.service.UserCredentialsService;

@Service
@Transactional 
public class ClientServiceImpl implements edu.mum.service.ClientService {
	
	@Autowired
	private ClientRestService clientRestService;

 	@Autowired
	private UserCredentialsService credentialsService;

 	
     public void save( Client client) {  		
  		clientRestService.save(client);
 	}
  	
     @Override
    	public void saveFull( Client client) {  		
   		credentialsService.save(client.getUserCredentials());
   		clientRestService.save(client);
 	}
   	
	
	public List<Client> findAll() {
		return (List<Client>)clientRestService.findAll();
	}

 	@Override
	public Client findOne(Integer id) {
		 
		return clientRestService.findOne(id);
	}
 

}
