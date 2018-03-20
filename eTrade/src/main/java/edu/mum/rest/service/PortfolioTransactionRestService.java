package edu.mum.rest.service;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.mum.domain.PortfolioTransaction;

@Component
public interface PortfolioTransactionRestService {

 	public List<PortfolioTransaction> findAll();

	public PortfolioTransaction findOne(Integer index);

	public PortfolioTransaction save(PortfolioTransaction portfolioTransaction);

}
