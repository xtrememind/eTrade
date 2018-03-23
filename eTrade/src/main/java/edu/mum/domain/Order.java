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

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id",scope = Order.class)
public class Order implements java.io.Serializable {

	private Integer id;

	private Date date;
	
	@NotNull (message="{quanity.message}")
	@Min(value=1 , message="{min.quantity}")
	private int quantity;
	@NotNull (message="{price.message}")
	@Min(value=1 , message="{min.price}")
	private double price;
	
	private double buyerBrokerFees;
	
	private double buyerMarketFees;
	
	private double buyerOrderAmount;
	
	private double sellerBrokerFees;
	
	private double sellerMarketFees;
	
	private double sellerOrderAmount;
	
	
	private Client buyerClient;
	
	
	private Client sellerClient;
	
	private Stock stock;
	
	private User user;

	public Order() {
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getBuyerBrokerFees() {
		return buyerBrokerFees;
	}

	public void setBuyerBrokerFees(double buyerBrokerFees) {
		this.buyerBrokerFees = buyerBrokerFees;
	}

	public double getBuyerMarketFees() {
		return buyerMarketFees;
	}

	public void setBuyerMarketFees(double buyerMarketFees) {
		this.buyerMarketFees = buyerMarketFees;
	}

	public double getBuyerOrderAmount() {
		return buyerOrderAmount;
	}

	public void setBuyerOrderAmount(double buyerOrderAmount) {
		this.buyerOrderAmount = buyerOrderAmount;
	}

	public double getSellerBrokerFees() {
		return sellerBrokerFees;
	}

	public void setSellerBrokerFees(double sellerBrokerFees) {
		this.sellerBrokerFees = sellerBrokerFees;
	}

	public double getSellerMarketFees() {
		return sellerMarketFees;
	}

	public void setSellerMarketFees(double sellerMarketFees) {
		this.sellerMarketFees = sellerMarketFees;
	}

	public double getSellerOrderAmount() {
		return sellerOrderAmount;
	}

	public void setSellerOrderAmount(double sellerOrderAmount) {
		this.sellerOrderAmount = sellerOrderAmount;
	}

	public Client getBuyerClient() {
		return buyerClient;
	}

	public void setBuyerClient(Client buyerClient) {
		this.buyerClient = buyerClient;
	}

	public Client getSellerClient() {
		return sellerClient;
	}

	public void setSellerClient(Client sellerClient) {
		this.sellerClient = sellerClient;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
