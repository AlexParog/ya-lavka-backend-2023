package ru.shbr.ya_lavka2023.dto;

import java.util.List;

/**
 * Запрос на создание одного или нескольких заказов.
 *
 * @param orderDtos список объектов {@link CreateOrderDto}, содержащих данные для создания заказов
 */
public record CreateOrderRequest(List<CreateOrderDto> orderDtos) {
}
