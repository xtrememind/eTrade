package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.Portfolio;
import edu.mum.rest.service.PortfolioRestService;

@Service
@Transactional 
public class PortfolioServiceImpl implements edu.mum.service.PortfolioService {
	
	@Autowired
	private PortfolioRestService portfolioRestService;

 	
     public void save( Portfolio portfolio) {  		
  		portfolioRestService.save(portfolio);
 	}
  	
    @Override
    	public void saveFull( Portfolio portfolio) {
   		portfolioRestService.save(portfolio);
 	}
   	
	
	public List<Portfolio> findAll() {
		return (List<Portfolio>)portfolioRestService.findAll();
	}

 	@Override
	public Portfolio findOne(Integer id) {
		 
		return portfolioRestService.findOne(id);
	}
 

}
