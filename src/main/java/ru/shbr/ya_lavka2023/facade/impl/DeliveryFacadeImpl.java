package ru.shbr.ya_lavka2023.facade.impl;

import org.springframework.stereotype.Service;
import ru.shbr.ya_lavka2023.dto.*;
import ru.shbr.ya_lavka2023.facade.DeliveryFacade;
import ru.shbr.ya_lavka2023.service.CourierService;
import ru.shbr.ya_lavka2023.service.OrderService;

import java.util.List;

/**
 * Реализация унифицированного интерфейса {@link DeliveryFacade}
 */
@Service
public class DeliveryFacadeImpl implements DeliveryFacade {
    private final CourierService courierService;
    private final OrderService orderService;

    /**
     * Конструктор
     *
     * @param courierService сервис курьеров
     * @param orderService   сервис заказов
     */
    public DeliveryFacadeImpl(CourierService courierService, OrderService orderService) {
        this.courierService = courierService;
        this.orderService = orderService;
    }

    @Override
    public CreateCouriersResponse saveCouriers(CreateCourierRequest courierRequest) {
        return courierService.saveCouriers(courierRequest);
    }

    @Override
    public CourierDto getCourierById(Long courierId) {
        return courierService.getCourierById(courierId);
    }

    @Override
    public GetCouriersResponse getAllCouriers(Integer offset, Integer limit) {
        return courierService.findCouriers(offset, limit);
    }

    @Override
    public void deleteCourier(Long courierId) {
        courierService.deleteCourierById(courierId);
    }

    @Override
    public CreateOrderResponse saveOrders(CreateOrderRequest createOrderRequest) {
        return orderService.saveOrders(createOrderRequest);
    }

    @Override
    public OrderDto getOrder(Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @Override
    public GetOrdersResponse getAllOrders(Integer offset, Integer limit) {
        return orderService.findOrders(offset, limit);
    }

    @Override
    public List<OrderDto> saveCompletedOrders(CompleteOrderRequestDto completeOrderRequestDto) {
        // TODO: необходимо валидация на заполнение данных
//        List<CompleteOrderDto> completeOrderDtos = completeOrderRequestDto.completeInfo();
//
//        for (CompleteOrderDto completedOrder : completeOrderDtos) {
//            Courier courier = courierService.findCourierOrNotFound(completedOrder.courierId());
//            Order order = orderService.findOrderOrNotFound(completedOrder.orderId());
//
//
//        }


        return null;
    }
}
