package com.practice.cqrs.command.model.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record PlaceOrderRequest(UUID customerId, BigDecimal total) {
}

