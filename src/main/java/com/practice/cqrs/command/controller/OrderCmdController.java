package com.practice.cqrs.command.controller;

import com.practice.cqrs.command.model.dto.PlaceOrderRequest;
import com.practice.cqrs.command.service.OrderServiceCmd;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/cmd")
public class OrderCmdController {
    private final OrderServiceCmd serviceCmd;

    public OrderCmdController(OrderServiceCmd serviceCmd) {
        this.serviceCmd = serviceCmd;
    }

    @PostMapping("/place")
    public ResponseEntity<Void> place(@RequestBody PlaceOrderRequest request) {
        serviceCmd.placeOrder(UUID.randomUUID(), request.customerId(), request.total());
        return ResponseEntity.ok().build();
    }
}
