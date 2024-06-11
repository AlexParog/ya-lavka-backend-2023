package ru.shbr.ya_lavka2023.dto;

import ru.shbr.ya_lavka2023.entity.CourierTypeEnum;

import java.util.Set;

/**
 * DTO для создания нового курьера без id {@link CourierDto}.
 *
 * @param courierType  тип курьера (например, пеший курьер, курьер на велосипеде)
 * @param areas        набор идентификаторов зон, в которых курьер работает
 * @param loadCapacity грузоподъемность курьера
 * @param workingHours набор идентификаторов рабочих часов курьера
 */
public record CreateCourierDto(CourierTypeEnum courierType,
                               Set<Integer> areas,
                               int loadCapacity,
                               Set<Integer> workingHours) {
}
