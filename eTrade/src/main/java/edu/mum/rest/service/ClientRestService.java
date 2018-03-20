package edu.mum.rest.service;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.mum.domain.Client;

@Component
public interface ClientRestService {

 	public List<Client> findAll();

	public Client findOne(Integer index);

	public Client save(Client client);

}
