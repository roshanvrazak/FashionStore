package com.fashionstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashionstore.entity.Customer;
import com.fashionstore.entity.Order;
import com.fashionstore.reporsitory.OrderRepository;
import com.fashionstore.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/{orderId}") // View Current order  --- in report
	public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
		Order order = orderService.getOrderById(orderId);
		if (order != null) {
			return ResponseEntity.ok(order);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// View Order Lists --- in report
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<List<Order>> getOrdersByCustomer(@PathVariable Long customerId) {
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		List<Order> orders = orderService.getOrdersByCustomer(customer);
		return ResponseEntity.ok(orders);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Order>> getAllOrders() {
		List<Order> orders = orderService.getAllOrders();
		return ResponseEntity.ok(orders);
	}

	@PostMapping
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {
		Order createdOrder = orderService.createOrder(order);
		return ResponseEntity.ok(createdOrder);
	}

	@PutMapping("/{orderId}")
	public ResponseEntity<Order> updateOrder(@PathVariable Long orderId, @RequestBody Order order) {
		order.setOrderId(orderId);
		Order updatedOrder = orderService.updateOrder(order);
		return ResponseEntity.ok(updatedOrder);
	}

	@DeleteMapping("/{orderId}")
	public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
		orderService.deleteOrder(orderId);
		return ResponseEntity.noContent().build();
	}
}
