package com.eficio.backend.services;

import com.eficio.backend.models.Order;
import com.eficio.backend.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public Order createOrder(Order order) {
        order.setDate(LocalDateTime.now());
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order order) {
        Order existingOrder = getOrderById(id);
        existingOrder.setCustomerName(order.getCustomerName());
        existingOrder.setStatus(order.getStatus());
        existingOrder.setTotal(order.getTotal());
        existingOrder.setPaymentMethod(order.getPaymentMethod());
        return orderRepository.save(existingOrder);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public List<Order> getOrdersByDateRange(LocalDateTime start, LocalDateTime end) {
        return orderRepository.findByDateBetween(start, end);
    }

    public List<Order> getOrdersByStatus(String status) {
        return orderRepository.findByStatus(status);
    }
} 