package com.practice.cqrs.query.controller;

import com.practice.cqrs.command.model.aggregate.OrderAggregate;
import com.practice.cqrs.query.service.OrderServiceQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/query")
public class OrderQueryController {
    private final OrderServiceQuery query;

    public OrderQueryController(OrderServiceQuery query) {
        this.query = query;
    }

    @GetMapping
    public List<OrderAggregate> getAll() {
        return query.getAllOrders();
    }

    @GetMapping("/{id}")
    public OrderAggregate getOrder(@PathVariable UUID id) {
        return query.getOrder(id);
    }
}
