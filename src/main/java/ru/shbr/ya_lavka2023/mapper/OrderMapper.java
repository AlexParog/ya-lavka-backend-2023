package ru.shbr.ya_lavka2023.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.shbr.ya_lavka2023.dto.CreateOrderDto;
import ru.shbr.ya_lavka2023.dto.OrderDto;
import ru.shbr.ya_lavka2023.entity.Order;

/**
 * Маппер для сущности {@link Order}
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {
    /**
     * Преобразует сущность {@link Order} в DTO {@link OrderDto}.
     *
     * @param order сущность {@link Order}
     * @return объект {@link OrderDto}, соответствующий переданной сущности
     */
    OrderDto toOrderDto(Order order);

    /**
     * Преобразует DTO {@link OrderDto} в сущность {@link Order}.
     *
     * @param orderDto объект {@link OrderDto}
     * @return сущность {@link Order}, соответствующая переданному DTO
     */
    Order toOrder(OrderDto orderDto);

    /**
     * Преобразует DTO {@link CreateOrderDto} в сущность {@link Order}.
     *
     * @param createOrderDto объект {@link CreateOrderDto}
     * @return сущность {@link Order}, соответствующая переданному DTO
     */
    Order toOrderFromCreateOrderDto(CreateOrderDto createOrderDto);
}
