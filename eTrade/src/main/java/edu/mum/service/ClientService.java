package edu.mum.service;

import java.util.List;

import edu.mum.domain.Client;
 
public interface ClientService {

	public void save(Client client);
	public List<Client> findAll();
	public Client findOne(Integer id);
 	public void saveFull( Client client);		

}
