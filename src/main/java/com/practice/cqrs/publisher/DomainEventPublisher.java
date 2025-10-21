package com.practice.cqrs.publisher;

import org.springframework.stereotype.Component;

@Component
public class DomainEventPublisher {
    public void publish(Object event) {
        System.out.println("Событие отправлено: " + event.getClass().getSimpleName());
    }
}
