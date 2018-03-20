package edu.mum.rest.service;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.mum.domain.Portfolio;

@Component
public interface PortfolioRestService {

 	public List<Portfolio> findAll();

	public Portfolio findOne(Integer index);

	public Portfolio save(Portfolio portfolio);

}
