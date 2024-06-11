package ru.shbr.ya_lavka2023.dto;

import java.util.Set;

/**
 * DTO для создания нового заказа.
 *
 * @param weight       вес заказа
 * @param area         идентификатор зоны доставки
 * @param deliveryTime набор строк, представляющих время доставки
 * @param price        стоимость заказа
 */
public record CreateOrderDto(int weight,
                             int area,
                             Set<String> deliveryTime,
                             int price) {
}
