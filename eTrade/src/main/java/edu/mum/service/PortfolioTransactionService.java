package edu.mum.service;

import java.util.List;

import edu.mum.domain.PortfolioTransaction;
 
public interface PortfolioTransactionService {

	public void save(PortfolioTransaction portfolioTransaction);
	public List<PortfolioTransaction> findAll();
	public PortfolioTransaction findOne(Integer id);
 	public void saveFull( PortfolioTransaction portfolioTransaction);		

}
