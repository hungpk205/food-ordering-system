package com.food.ordering.system.order.service.domain;

import com.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand;
import com.food.ordering.system.order.service.domain.dto.create.CreateOrderResponse;
import com.food.ordering.system.order.service.domain.dto.track.TrackOrderQuery;
import com.food.ordering.system.order.service.domain.dto.track.TrackOrderResponse;
import com.food.ordering.system.order.service.domain.handler.OrderCreateCommandHandler;
import com.food.ordering.system.order.service.domain.handler.OrderTrackingCommandHandler;
import com.food.ordering.system.order.service.domain.ports.input.service.OrderApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Slf4j
@Validated
class OrderApplicationServiceImpl implements OrderApplicationService {

    private final OrderCreateCommandHandler orderCreateCommandHandler;

    private final OrderTrackingCommandHandler orderTrackingCommandHandler;

    OrderApplicationServiceImpl(final OrderCreateCommandHandler orderCreateCommandHandler,
                                final OrderTrackingCommandHandler orderTrackingCommandHandler) {
        this.orderCreateCommandHandler = orderCreateCommandHandler;
        this.orderTrackingCommandHandler = orderTrackingCommandHandler;
    }

    @Override
    public CreateOrderResponse createOrder(final CreateOrderCommand createOrderCommand) {
        return orderCreateCommandHandler.createOrder(createOrderCommand);
    }

    @Override
    public TrackOrderResponse trackOrder(final TrackOrderQuery trackOrderQuery) {
        return orderTrackingCommandHandler.trackOrder(trackOrderQuery);
    }
}
