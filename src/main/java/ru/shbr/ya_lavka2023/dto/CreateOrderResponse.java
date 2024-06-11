package ru.shbr.ya_lavka2023.dto;

import java.util.List;

/**
 * Ответ при создании одного или нескольких заказов.
 *
 * @param couriers список объектов {@link OrderDto}, содержащих данные о созданных заказах
 */
public record CreateOrderResponse(List<OrderDto> couriers) {
}
