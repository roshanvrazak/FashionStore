package com.fashionstore.service;
import java.util.List;

import com.fashionstore.entity.Customer;

public interface CustomerService {

    Customer getCustomerById(Long customerId);

    Customer getCustomerByUsername(String username);

    Customer getCustomerByEmail(String email);

    List<Customer> getAllCustomers();

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    void deleteCustomer(Long customerId);
}
