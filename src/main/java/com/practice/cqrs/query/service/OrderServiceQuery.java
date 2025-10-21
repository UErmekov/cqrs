package com.practice.cqrs.query.service;

import com.practice.cqrs.command.model.aggregate.OrderAggregate;
import com.practice.cqrs.command.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceQuery {
    private final OrderRepository orderRepository;

    public OrderServiceQuery(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderAggregate> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderAggregate getOrder(UUID id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
