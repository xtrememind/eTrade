package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.PortfolioBalance;
import edu.mum.rest.service.PortfolioBalanceRestService;

@Service
@Transactional 
public class PortfolioBalanceServiceImpl implements edu.mum.service.PortfolioBalanceService {
	
	@Autowired
	private PortfolioBalanceRestService portfolioBalanceRestService;

 	
     public void save( PortfolioBalance portfolioBalance) {  		
  		portfolioBalanceRestService.save(portfolioBalance);
 	}
  	
    @Override
    	public void saveFull( PortfolioBalance portfolioBalance) {
   		portfolioBalanceRestService.save(portfolioBalance);
 	}
   	
	
	public List<PortfolioBalance> findAll() {
		return (List<PortfolioBalance>)portfolioBalanceRestService.findAll();
	}

 	@Override
	public PortfolioBalance findOne(Integer id) {
		 
		return portfolioBalanceRestService.findOne(id);
	}
 

}
