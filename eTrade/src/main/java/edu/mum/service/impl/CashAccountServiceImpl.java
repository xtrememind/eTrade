package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.domain.CashAccount;
import edu.mum.rest.service.CashAccountRestService;

@Service
@Transactional 
public class CashAccountServiceImpl implements edu.mum.service.CashAccountService {
	
	@Autowired
	private CashAccountRestService cashAccountRestService;

 	
     public void save( CashAccount cashAccount) {  		
  		cashAccountRestService.save(cashAccount);
 	}
  	
    @Override
    	public void saveFull( CashAccount cashAccount) {
   		cashAccountRestService.save(cashAccount);
 	}
   	
	
	public List<CashAccount> findAll() {
		return (List<CashAccount>)cashAccountRestService.findAll();
	}

 	@Override
	public CashAccount findOne(Integer id) {
		 
		return cashAccountRestService.findOne(id);
	}
 
 	@Override
	public CashAccount update(CashAccount cashAccount)  {
		 
		return cashAccountRestService.update(cashAccount);
	}
 

}
