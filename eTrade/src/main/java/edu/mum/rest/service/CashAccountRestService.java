package edu.mum.rest.service;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.mum.domain.CashAccount;

@Component
public interface CashAccountRestService {

 	public List<CashAccount> findAll();

	public CashAccount findOne(Integer index);

	public CashAccount save(CashAccount cashAccount);
	public CashAccount update(CashAccount cashAccount) ;

}
