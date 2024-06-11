package ru.shbr.ya_lavka2023.dto;

import java.util.List;

/**
 * Ответ при создании одного или нескольких курьеров.
 *
 * @param couriers список объектов {@link CourierDto}, содержащих данные о созданных курьерах
 */
public record CreateCouriersResponse(List<CourierDto> couriers) {
}
