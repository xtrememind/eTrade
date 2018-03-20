package edu.mum.rest.service;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.mum.domain.Stock;

@Component
public interface StockRestService {

 	public List<Stock> findAll();

	public Stock findOne(Integer index);

	public Stock save(Stock stock);

}
