package edu.mum.service;

import java.util.List;

import edu.mum.domain.PortfolioBalance;
 
public interface PortfolioBalanceService {

	public void save(PortfolioBalance portfolioBalance);
	public List<PortfolioBalance> findAll();
	public PortfolioBalance findOne(Integer id);
 	public void saveFull( PortfolioBalance portfolioBalance);		

}
