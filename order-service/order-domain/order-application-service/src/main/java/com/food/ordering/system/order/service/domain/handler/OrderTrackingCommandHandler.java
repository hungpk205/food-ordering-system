package com.food.ordering.system.order.service.domain.handler;

import com.food.ordering.system.order.serice.domain.exception.OrderNotFoundException;
import com.food.ordering.system.order.serice.domain.valueobject.TrackingId;
import com.food.ordering.system.order.service.domain.dto.track.TrackOrderQuery;
import com.food.ordering.system.order.service.domain.dto.track.TrackOrderResponse;
import com.food.ordering.system.order.service.domain.mapper.OrderDataMapper;
import com.food.ordering.system.order.service.domain.ports.output.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class OrderTrackingCommandHandler {

    private final OrderDataMapper orderDataMapper;

    private final OrderRepository orderRepository;

    public OrderTrackingCommandHandler(final OrderDataMapper orderDataMapper,
                                       final OrderRepository orderRepository) {
        this.orderDataMapper = orderDataMapper;
        this.orderRepository = orderRepository;
    }

    @Transactional(readOnly = true)
    public TrackOrderResponse trackOrder(TrackOrderQuery trackOrderQuery) {
        var orderResult = orderRepository.findByTrackingId(new TrackingId(trackOrderQuery.getOrderTrackingId()))
                                         .orElseThrow(
                                             () -> new OrderNotFoundException("Not found order"));
        return orderDataMapper.orderToTrackOrderResponse(orderResult);
    }
}
