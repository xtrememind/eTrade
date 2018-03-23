package edu.mum.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id", scope = CashTransaction.class)
public class CashTransaction implements java.io.Serializable {

	// the id 
	private Integer id;
	
	@NotNull (message="{date.message}")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	@NotNull (message="{amount.message}")
	@Min(value=1000 , message="{amount.message}")
     private Double amount;
	
	private double balance;
	
	@NotEmpty(message="{description.message}")
     private String description;
	
	@Valid
	private CashAccount cashAccount;


	public CashTransaction() {
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public CashAccount getCashAccount() {
		return cashAccount;
	}


	public void setCashAccount(CashAccount cashAccount) {
		this.cashAccount = cashAccount;
	}
	
}
