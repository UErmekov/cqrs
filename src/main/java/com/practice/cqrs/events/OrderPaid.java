package com.practice.cqrs.events;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class OrderPaid {
    private UUID orderId;
    private UUID customerId;
    private String receipt;
    private BigDecimal amount;

}
