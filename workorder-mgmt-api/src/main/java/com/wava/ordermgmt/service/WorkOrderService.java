package com.wava.ordermgmt.service;

import java.util.ArrayList;
import java.util.List;
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

	public Order findOrderById(long orderId) {
		final Optional<Order> optDBOrder = this.orderRepository.findById(orderId);
		if (!optDBOrder.isPresent()) {
			throw new RecordNotFoundException(String.format("Order %s does not exist", orderId));
		}
		return optDBOrder.get();
	}

	public List<Order> getAllOrders() {
		final List<Order> orders = new ArrayList<Order>();
		final Iterable<Order> iterable = this.orderRepository.findAll();
		iterable.forEach(order -> orders.add(order));
		return orders;

	}

}
