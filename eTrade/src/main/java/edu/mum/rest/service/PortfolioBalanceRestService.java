package edu.mum.rest.service;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.mum.domain.PortfolioBalance;

@Component
public interface PortfolioBalanceRestService {

 	public List<PortfolioBalance> findAll();

	public PortfolioBalance findOne(Integer index);

	public PortfolioBalance save(PortfolioBalance portfolioBalance);

}
