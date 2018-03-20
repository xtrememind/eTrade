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

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Client implements java.io.Serializable {

	private Integer id;
    
	private String name;
    
	private Portfolio portfolio;
 
	private CashAccount cashAccount;

	private UserCredentials userCredentials;
	
	private List<Order> boughtOrders = new ArrayList<Order>();
	
	private List<Order> SoldOrders = new ArrayList<Order>();
	
	public Client() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	public CashAccount getCashAccount() {
		return cashAccount;
	}

	public void setCashAccount(CashAccount cashAccount) {
		this.cashAccount = cashAccount;
	}

	public UserCredentials getUserCredentials() {
		return userCredentials;
	}

	public void setUserCredentials(UserCredentials userCredentials) {
		this.userCredentials = userCredentials;
	}

	public List<Order> getBoughtOrders() {
		return boughtOrders;
	}

	public void setBoughtOrders(List<Order> boughtOrders) {
		this.boughtOrders = boughtOrders;
	}

	public List<Order> getSoldOrders() {
		return SoldOrders;
	}

	public void setSoldOrders(List<Order> soldOrders) {
		SoldOrders = soldOrders;
	}

}
