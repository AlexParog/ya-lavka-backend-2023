package ru.shbr.ya_lavka2023.service.impl;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.shbr.ya_lavka2023.dto.*;
import ru.shbr.ya_lavka2023.entity.Order;
import ru.shbr.ya_lavka2023.exception.BadRequestException;
import ru.shbr.ya_lavka2023.exception.NotFoundException;
import ru.shbr.ya_lavka2023.mapper.OrderMapper;
import ru.shbr.ya_lavka2023.repository.OrderRepository;
import ru.shbr.ya_lavka2023.service.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Реализация {@link OrderService}
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public CreateOrderResponse saveOrders(CreateOrderRequest createOrderRequest) {
        // TODO: необходимо валидация на заполнение данных
        List<CreateOrderDto> createOrderDtos = createOrderRequest.orderDtos();
        List<Order> savedOrders = new ArrayList<>();

        for (CreateOrderDto dto : createOrderDtos) {
            Order order = orderMapper.toOrderFromCreateOrderDto(dto);
            savedOrders.add(order);
        }
        orderRepository.saveAll(savedOrders);

        List<OrderDto> orderDtos = savedOrders
                .stream()
                .map(orderMapper::toOrderDto)
                .toList();

        return new CreateOrderResponse(orderDtos);
    }

    @Override
    public OrderDto getOrderById(Long orderId) {
        return orderMapper.toOrderDto(findOrderOrNotFound(orderId));
    }

    @Override
    public GetOrdersResponse findOrders(Integer offset, Integer limit) {
        if (Objects.equals(limit, offset)) {
            throw new BadRequestException(
                    String.format("Параметры offset=%d и limit=%d не могут быть равны", offset, limit));
        }

        List<Order> orders = orderRepository.findAll(new OrderPaginationRequest(offset, limit, Sort.unsorted()))
                .stream()
                .toList();

        return GetOrdersResponse.builder()
                .orders(orders
                        .stream()
                        .map(orderMapper::toOrderDto)
                        .toList())
                .offset(offset)
                .limit(limit)
                .build();
    }

    @Override
    public Order findOrderOrNotFound(Long id) {
        return orderRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Order с id=%d не найден!", id)));
    }
}
