package com.wava.ordermgmt.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "ORDER")
@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private long orderId;

	/*
	 * @Basic
	 * 
	 * @Temporal(TemporalType.TIMES	TAMP)
	 * 
	 * @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	 * 
	 * @Column(name = "order_date") private Date orderDate;
	 */
	

    @OneToMany(mappedBy = "order")
    private Set<OrderLineItem> orderLineItems;


	@Column(name = "order_status")
	private String orderStatus;

	@Column(name = "order_total")
	private float orderTotal;
	
	public Order() {}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
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
	
	

	

}
