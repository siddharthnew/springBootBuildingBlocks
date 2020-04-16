package com.stackSimplify.restServices.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Orders")
public class Order {

	@Id
	@GeneratedValue
	private Long orderId;
	private String orderDescription;

	// multiple ordrs can be associated with single user
	// FetchType=lazy means until n unless we expliciltly call user from order table, it is not going to show user details
    // to see user details from order table-we need to call order.user from a query
	
	
	@ManyToOne(fetch = FetchType.LAZY) 
	@JsonIgnore
	private User user;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
