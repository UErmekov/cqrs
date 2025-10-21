package com.practice.cqrs.events;

import java.math.BigDecimal;
import java.util.UUID;
import java.time.Instant;

public class OrderPlacedEvent {
    private final UUID orderId;
    private final UUID customerId;
    private final BigDecimal total;
    private final Instant occurredAt;

    public OrderPlacedEvent(UUID orderId, UUID customerId, BigDecimal total) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.total = total;
        this.occurredAt = Instant.now();
    }

    public UUID getOrderId() {
        return orderId;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Instant getOccurredAt() {
        return occurredAt;
    }
}

