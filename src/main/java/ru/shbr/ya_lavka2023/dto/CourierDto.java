package ru.shbr.ya_lavka2023.dto;

import ru.shbr.ya_lavka2023.entity.CourierTypeEnum;

import java.util.Set;

/**
 * Dto Курьера {@link ru.shbr.ya_lavka2023.entity.Courier} со всеми полями
 *
 * @param id              идентификатор курьера
 * @param courierTypeEnum тип передвижения
 * @param areas           районы
 * @param loadCapacity    грузоподъемность
 * @param workingHours    промежутки работы
 */
public record CourierDto(Long id,
                         CourierTypeEnum courierTypeEnum,
                         Set<Integer> areas,
                         int loadCapacity,
                         Set<String> workingHours) {
}
