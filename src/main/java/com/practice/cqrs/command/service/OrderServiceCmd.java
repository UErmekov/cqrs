package com.practice.cqrs.command.service;

import com.practice.cqrs.command.model.aggregate.OrderAggregate;
import com.practice.cqrs.command.repository.OrderRepository;
import com.practice.cqrs.events.OrderPlacedEvent;
import com.practice.cqrs.publisher.DomainEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Service
public class OrderServiceCmd {
    private final OrderRepository orderRepository;
    private final DomainEventPublisher domainEventPublisher;

    public OrderServiceCmd(OrderRepository orderRepository, DomainEventPublisher domainEventPublisher) {
        this.orderRepository = orderRepository;
        this.domainEventPublisher = domainEventPublisher;
    }

    @Transactional
    public void placeOrder(UUID orderId, UUID customerId, BigDecimal total) {
        OrderAggregate aggregate = new OrderAggregate();
        aggregate.setId(orderId);
        aggregate.setCustomerId(customerId);
        aggregate.setTotal(total);
        aggregate.setStatus("PLACED");
        aggregate.setCreatedAt(Instant.now());

        orderRepository.save(aggregate);
        domainEventPublisher.publish(new OrderPlacedEvent(orderId, customerId, total));
    }

}
