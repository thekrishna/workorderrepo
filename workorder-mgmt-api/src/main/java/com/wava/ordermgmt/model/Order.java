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

@Table(name = "ORDER_TBL")
@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/*
	 * @Column(name = "order_id") private long orderId;
	 */
	@Column(name = "id")
	private Long id;

	@Column(name = "order_date")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime orderDate;

	@Column(name = "order_status")
	private String orderStatus;

	@Column(name = "order_total")
	private float orderTotal;

	//@OneToMany(mappedBy = "order", cascade = CascadeType.ALL) //targetEntity = OrderLineItem.class)
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

	@Override
	public String toString() {
		return "Order [orderId=" + id + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus
				+ ", orderTotal=" + orderTotal + ", orderLineItems=" + orderLineItems + "]";
	}

}
