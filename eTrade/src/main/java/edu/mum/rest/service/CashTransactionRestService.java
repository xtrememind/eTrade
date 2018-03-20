package edu.mum.rest.service;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.mum.domain.CashTransaction;

@Component
public interface CashTransactionRestService {

 	public List<CashTransaction> findAll();

	public CashTransaction findOne(Integer index);

	public CashTransaction save(CashTransaction cashTransaction);

}
