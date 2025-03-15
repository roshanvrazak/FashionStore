package com.fashionstore.service;

import java.util.List;

import com.fashionstore.entity.Order;
import com.fashionstore.entity.OrderItem;

public interface OrderItemService {

    OrderItem getOrderItemById(Long orderItemId);

    List<OrderItem> getOrderItemsByOrder(Order order);

    List<OrderItem> getAllOrderItems();

    OrderItem createOrderItem(OrderItem orderItem);

    OrderItem updateOrderItem(OrderItem orderItem);

    void deleteOrderItem(Long orderItemId);
}

