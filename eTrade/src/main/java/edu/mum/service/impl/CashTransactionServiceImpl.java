package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.CashTransaction;
import edu.mum.rest.service.CashTransactionRestService;

@Service
@Transactional 
public class CashTransactionServiceImpl implements edu.mum.service.CashTransactionService {
	
	@Autowired
	private CashTransactionRestService cashTransactionRestService;

 	
     public void save( CashTransaction cashTransaction) {  		
  		cashTransactionRestService.save(cashTransaction);
 	}
  	
    @Override
    	public void saveFull( CashTransaction cashTransaction) {
   		cashTransactionRestService.save(cashTransaction);
 	}
   	
	
	public List<CashTransaction> findAll() {
		return (List<CashTransaction>)cashTransactionRestService.findAll();
	}

 	@Override
	public CashTransaction findOne(Integer id) {
		 
		return cashTransactionRestService.findOne(id);
	}
 

}
