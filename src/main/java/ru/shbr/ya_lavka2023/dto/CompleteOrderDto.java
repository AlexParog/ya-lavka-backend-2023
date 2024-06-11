package ru.shbr.ya_lavka2023.dto;

/**
 * DTO для завершения заказа.
 *
 * @param courierId    идентификатор курьера, завершившего заказ
 * @param orderId      идентификатор завершенного заказа
 * @param completeTime время завершения заказа в формате строки
 */
public record CompleteOrderDto(Long courierId, Long orderId, String completeTime) {
}
