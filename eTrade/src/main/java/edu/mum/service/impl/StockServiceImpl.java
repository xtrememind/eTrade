package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.Stock;
import edu.mum.rest.service.StockRestService;

@Service
@Transactional 
public class StockServiceImpl implements edu.mum.service.StockService {
	
	@Autowired
	private StockRestService stockRestService;
 	
     public void save( Stock stock) {  		
  		stockRestService.save(stock);
 	}
  	
     @Override
    	public void saveFull( Stock stock) {  		
   		stockRestService.save(stock);
 	}
   	
	
	public List<Stock> findAll() {
		return (List<Stock>)stockRestService.findAll();
	}

 	@Override
	public Stock findOne(Integer id) {
		 
		return stockRestService.findOne(id);
	}
 

}
