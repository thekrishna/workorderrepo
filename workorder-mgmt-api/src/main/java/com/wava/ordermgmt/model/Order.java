package com.wava.ordermgmt.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@Table(name = "ORDER_TBL")
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "order_date")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime orderDate;

	@Column(name = "order_status")
	private String orderStatus;

	@Column(name = "channelType")
	private String channelType;
	
	@Column(name = "order_total")
	private float orderTotal;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<OrderLineItem> orderLineItems;

	public Order() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public float getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(float orderTotal) {
		this.orderTotal = orderTotal;
	}

	public Set<OrderLineItem> getOrderLineItems() {
		return orderLineItems;
	}

	public void setOrderLineItems(Set<OrderLineItem> orderLineItems) {
		this.orderLineItems = orderLineItems;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus + ", channelType="
				+ channelType + ", orderTotal=" + orderTotal + ", orderLineItems=" + orderLineItems + ", getId()="
				+ getId() + ", getOrderDate()=" + getOrderDate() + ", getOrderStatus()=" + getOrderStatus()
				+ ", getOrderTotal()=" + getOrderTotal() + ", getOrderLineItems()=" + getOrderLineItems()
				+ ", getChannelType()=" + getChannelType() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


}
