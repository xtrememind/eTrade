package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.PortfolioTransaction;
import edu.mum.rest.service.PortfolioTransactionRestService;

@Service
@Transactional 
public class PortfolioTransactionServiceImpl implements edu.mum.service.PortfolioTransactionService {
	
	@Autowired
	private PortfolioTransactionRestService portfolioTransactionRestService;

 	
     public void save( PortfolioTransaction portfolioTransaction) {  		
  		portfolioTransactionRestService.save(portfolioTransaction);
 	}
  	
    @Override
    	public void saveFull( PortfolioTransaction portfolioTransaction) {
   		portfolioTransactionRestService.save(portfolioTransaction);
 	}
   	
	
	public List<PortfolioTransaction> findAll() {
		return (List<PortfolioTransaction>)portfolioTransactionRestService.findAll();
	}

 	@Override
	public PortfolioTransaction findOne(Integer id) {
		 
		return portfolioTransactionRestService.findOne(id);
	}
 

}
