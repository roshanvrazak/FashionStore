package com.fashionstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashionstore.entity.Admin;
import com.fashionstore.entity.Customer;
import com.fashionstore.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/register") // register new user --- in report
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
		Customer savedCustomer = customerService.createCustomer(customer);
		return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
	}

	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
		Customer customer = customerService.getCustomerById(customerId);
		if (customer != null) {
			return ResponseEntity.ok(customer);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/all")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customers = customerService.getAllCustomers();
		return ResponseEntity.ok(customers);
	}

	@PostMapping
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		// Customer createdCustomer = customerService.createCustomer(customer);
		// return ResponseEntity.ok(createdCustomer);

		return ResponseEntity.ok(customerService.createCustomer(customer));
	}

	@PutMapping("/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId, @RequestBody Customer customer) {
		customer.setCustomerId(customerId);
		Customer updatedCustomer = customerService.updateCustomer(customer);
		return ResponseEntity.ok(updatedCustomer);
	}

	@DeleteMapping("/{customerId}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId) {
		customerService.deleteCustomer(customerId);
		return ResponseEntity.ok().build();
	}

}
