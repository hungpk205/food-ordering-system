package com.food.ordering.system.order.serice.domain.event;

import com.food.ordering.system.domain.event.DomainEvent;
import com.food.ordering.system.order.serice.domain.entity.Order;

import java.time.ZonedDateTime;

public abstract class OrderEvent implements DomainEvent<Order> {
    Order order;
    ZonedDateTime createdAt;

    public OrderEvent(final Order order, final ZonedDateTime createdAt) {
        this.order = order;
        this.createdAt = createdAt;
    }

    public Order getOrder() {
        return order;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
