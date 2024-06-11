package ru.shbr.ya_lavka2023.dto;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

/**
 * Запрос на завершение одного или нескольких заказов.
 *
 * @param completeInfo список объектов {@link CompleteOrderDto}, содержащих информацию о завершении заказов
 */
public record CompleteOrderRequestDto(@NotEmpty List<CompleteOrderDto> completeInfo) {
}
