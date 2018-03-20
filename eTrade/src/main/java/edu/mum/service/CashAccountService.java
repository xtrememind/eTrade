package edu.mum.service;

import java.util.List;

import edu.mum.domain.CashAccount;
 
public interface CashAccountService {

	public void save(CashAccount cashAccount);
	public List<CashAccount> findAll();
	public CashAccount findOne(Integer id);
 	public void saveFull( CashAccount cashAccount);		

}
