package com.food.ordering.system.order.service.domain.handler;

import com.food.ordering.system.order.serice.domain.OrderDomainService;
import com.food.ordering.system.order.serice.domain.entity.Order;
import com.food.ordering.system.order.serice.domain.entity.Restaurant;
import com.food.ordering.system.order.serice.domain.event.OrderCreatedEvent;
import com.food.ordering.system.order.serice.domain.exception.OrderDomainException;
import com.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand;
import com.food.ordering.system.order.service.domain.dto.create.CreateOrderResponse;
import com.food.ordering.system.order.service.domain.mapper.OrderDataMapper;
import com.food.ordering.system.order.service.domain.ports.output.repository.CustomerRepository;
import com.food.ordering.system.order.service.domain.ports.output.repository.OrderRepository;
import com.food.ordering.system.order.service.domain.ports.output.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderCreateCommandHandler {
    private final OrderDomainService orderDomainService;
    private final OrderDataMapper orderDataMapper;
    private final CustomerRepository customerRepository;

    private final RestaurantRepository restaurantRepository;

    private final OrderRepository orderRepository;

    @Transactional
    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        checkCustomer(createOrderCommand.getCustomerId());
        var restaurant = checkRestaurant(createOrderCommand);
        var order = orderDataMapper.createOrderCommandToOrder(createOrderCommand);
        OrderCreatedEvent orderCreatedEvent = orderDomainService.validateAndInitiateOrder(order, restaurant);
        var orderSaved = saveOrder(order);
        return orderDataMapper.orderToCreateOrderResponse(orderSaved, "Order created success!");
    }

    private void checkCustomer(UUID customerId) {
        customerRepository.findCustomer(customerId).orElseThrow(
            () ->new OrderDomainException("Not exist customer with id: " + customerId)
        );
    }

    private Restaurant checkRestaurant(CreateOrderCommand createOrderCommand) {
        var restaurant = orderDataMapper.createOrderCommandToRestaurant(createOrderCommand);
        return restaurantRepository.findRestaurantInformation(restaurant).orElseThrow(
            () -> new OrderDomainException("Could not find restaurant with restaurant id: " + restaurant.getId())
        );
    }

    private Order saveOrder(Order order) {
        var orderSaved = orderRepository.save(order);
        if (order == null) {
            log.info("Can not save order!");
            throw new OrderDomainException("Can not save order!");
        }
        return orderSaved;
    }
}
