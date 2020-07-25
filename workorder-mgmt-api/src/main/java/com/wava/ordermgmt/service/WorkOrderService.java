package com.wava.ordermgmt.service;

import org.springframework.stereotype.Service;

import com.wava.ordermgmt.repository.OrderRepository;

@Service
public class WorkOrderService {
	private OrderRepository orderRepository;
	
	public WorkOrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
}
