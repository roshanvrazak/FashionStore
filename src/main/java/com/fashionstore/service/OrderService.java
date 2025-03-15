package com.fashionstore.service;
import java.util.List;

import com.fashionstore.entity.Customer;
import com.fashionstore.entity.Order;

public interface OrderService {

    Order getOrderById(Long orderId);

    List<Order> getOrdersByCustomer(Customer customer);

    List<Order> getAllOrders();

    Order createOrder(Order order);

    Order updateOrder(Order order);

    void deleteOrder(Long orderId);
}
