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

import com.fashionstore.entity.Order;
import com.fashionstore.entity.OrderItem;
import com.fashionstore.service.OrderItemService;

@RestController
@RequestMapping("/api/orderitems")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/{orderItemId}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Long orderItemId) {
        OrderItem orderItem = orderItemService.getOrderItemById(orderItemId);
        if (orderItem != null) {
            return ResponseEntity.ok(orderItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<OrderItem>> getOrderItemsByOrder(@PathVariable Long orderId) {
        Order order = new Order();
        order.setOrderId(orderId);
        List<OrderItem> orderItems = orderItemService.getOrderItemsByOrder(order);
        return ResponseEntity.ok(orderItems);
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderItem>> getAllOrderItems() {
        List<OrderItem> orderItems = orderItemService.getAllOrderItems();
        return ResponseEntity.ok(orderItems);
    }

    @PostMapping
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItem orderItem) {
        OrderItem createdOrderItem = orderItemService.createOrderItem(orderItem);
        return ResponseEntity.ok(createdOrderItem);
    }

    @PutMapping("/{orderItemId}")
    public ResponseEntity<OrderItem> updateOrderItem(@PathVariable Long orderItemId, @RequestBody OrderItem orderItem) {
        orderItem.setOrderItemId(orderItemId);
        OrderItem updatedOrderItem = orderItemService.updateOrderItem(orderItem);
        return ResponseEntity.ok(updatedOrderItem);
    }

    @DeleteMapping("/{orderItemId}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long orderItemId) {
        orderItemService.deleteOrderItem(orderItemId);
        return ResponseEntity.noContent().build();
    }
}
