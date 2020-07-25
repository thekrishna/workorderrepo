package com.wava.ordermgmt.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wava.ordermgmt.exception.RecordNotFoundException;
import com.wava.ordermgmt.model.Order;
import com.wava.ordermgmt.repository.OrderRepository;

@Service
public class WorkOrderService {
	private OrderRepository orderRepository;

	public WorkOrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public Order saveOrder(final Order order) {
		return this.orderRepository.save(order);
	}

	public void deleteOrder(final long orderId) {
		final Optional<Order> optDBOrder = this.orderRepository.findById(orderId);
		if (!optDBOrder.isPresent()) {
			throw new RecordNotFoundException(String.format("Order %s does not exist", orderId));
		}
		final Order fromDB = optDBOrder.get();
		fromDB.setOrderStatus("Cancelled");
		this.orderRepository.save(fromDB);
	}
}
