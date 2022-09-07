package com.food.ordering.system.order.service.domain;

import com.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand;
import com.food.ordering.system.order.service.domain.dto.create.CreateOrderResponse;
import com.food.ordering.system.order.service.domain.dto.track.TrackOrderQuery;
import com.food.ordering.system.order.service.domain.dto.track.TrackOrderResponse;
import com.food.ordering.system.order.service.domain.ports.input.service.OrderApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderApplicationServiceImpl implements OrderApplicationService {
    @Override
    public CreateOrderResponse createOrder(final CreateOrderCommand createOrderCommand) {
        return null;
    }

    @Override
    public TrackOrderResponse trackOrder(final TrackOrderQuery trackOrderQuery) {
        return null;

    }
}
