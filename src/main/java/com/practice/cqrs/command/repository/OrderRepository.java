package com.practice.cqrs.command.repository;

import com.practice.cqrs.command.model.aggregate.OrderAggregate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderAggregate, UUID> {
}
