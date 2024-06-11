package ru.shbr.ya_lavka2023.dto;

import java.util.List;

/**
 * Запрос на создание одного или нескольких курьеров.
 *
 * @param couriers список объектов {@link CreateCourierDto}, содержащих данные для создания курьеров
 */
public record CreateCourierRequest(List<CreateCourierDto> couriers) {
}
