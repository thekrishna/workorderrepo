package com.wava.ordermgmt.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class OrderLineItem {
	@Id
	private long orderLineNumber;
	private String orderDescription;
	private Integer quantity;
	private BigDecimal price;
	private String topping1;
	private String topping2;
	private String topping3;
	private String productCode;
	
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
