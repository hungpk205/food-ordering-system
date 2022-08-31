package com.food.ordering.system.order.serice.domain.valueobject;

import com.food.ordering.system.domain.valueobject.BaseId;

import java.util.UUID;

public class TrackingId extends BaseId<UUID> {
    public TrackingId(final UUID value) {
        super(value);
    }
}
