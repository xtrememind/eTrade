package edu.mum.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id", scope = Portfolio.class)
public class Portfolio implements java.io.Serializable {

	private Integer id;

	private Integer brokerFees;

	private Integer marketFees;
    
	private Client client;
    
	private List<PortfolioBalance> portfolioBalances = new ArrayList<PortfolioBalance>();
    

	public Portfolio() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBrokerFees() {
		return brokerFees;
	}

	public void setBrokerFees(Integer brokerFees) {
		this.brokerFees = brokerFees;
	}

	public Integer getMarketFees() {
		return marketFees;
	}

	public void setMarketFees(Integer marketFees) {
		this.marketFees = marketFees;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<PortfolioBalance> getPortfolioBalances() {
		return portfolioBalances;
	}

	public void setPortfolioBalances(List<PortfolioBalance> portfolioBalances) {
		this.portfolioBalances = portfolioBalances;
	}


}
