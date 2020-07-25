package com.wava.ordermgmt.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "ORDER_LINE_ITEM")
@Entity
public class OrderLineItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_line_number")
	private long orderLineNumber;

	@Column(name = "order_description")
	private String orderDescription;
	private Integer quantity;
	private BigDecimal price;
	private String topping1;
	private String topping2;
	private String topping3;
	private String productCode;

	@ManyToOne()
	@JoinColumn(name = "order_id", nullable = false, insertable = false, updatable = false)
	private Order order;

	public OrderLineItem() {
	}

	public OrderLineItem(Order order) {
		this.order = order;
	}
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		if (order == null) {
			this.order = new Order();
		} else {
			this.order = order;
		}
	}

	public long getOrderLineNumber() {
		return orderLineNumber;
	}

	public void setOrderLineNumber(long orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getTopping1() {
		return topping1;
	}

	public void setTopping1(String topping1) {
		this.topping1 = topping1;
	}

	public String getTopping2() {
		return topping2;
	}

	public void setTopping2(String topping2) {
		this.topping2 = topping2;
	}

	public String getTopping3() {
		return topping3;
	}

	public void setTopping3(String topping3) {
		this.topping3 = topping3;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	

}
