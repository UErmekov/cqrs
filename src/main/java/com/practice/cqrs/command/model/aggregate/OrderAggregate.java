package com.practice.cqrs.command.model.aggregate;

import com.practice.cqrs.enums.OrderState;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Data
public class OrderAggregate {
    @Id
    private UUID id;
    private UUID customerId;
    private BigDecimal total;
    private OrderState status;
    private Instant createdAt;

}
