package com.practice.cqrs.events.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "event_store")
@Data
public class EventStore {
    @Id
    private UUID id;

    private UUID aggregateId;

    private String eventType;

    private String payload;

    private Instant createdAt;

}
