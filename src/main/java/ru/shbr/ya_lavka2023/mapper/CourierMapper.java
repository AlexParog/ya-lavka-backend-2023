package ru.shbr.ya_lavka2023.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.shbr.ya_lavka2023.dto.CourierDto;
import ru.shbr.ya_lavka2023.dto.CreateCourierDto;
import ru.shbr.ya_lavka2023.entity.Courier;

/**
 * Маппер для сущности {@link Courier}
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CourierMapper {
    /**
     * Преобразует сущность {@link Courier} в DTO {@link CourierDto}.
     *
     * @param courier сущность {@link Courier}
     * @return объект {@link CourierDto}, соответствующий переданной сущности
     */
    CourierDto toCourierDto(Courier courier);

    /**
     * Преобразует DTO {@link CourierDto} в сущность {@link Courier}.
     *
     * @param courierDto объект {@link CourierDto}
     * @return сущность {@link Courier}, соответствующая переданному DTO
     */
    Courier toCourier(CourierDto courierDto);

    /**
     * Преобразует DTO {@link CreateCourierDto} в сущность {@link Courier}.
     *
     * @param createCourierDto объект {@link CreateCourierDto}
     * @return сущность {@link Courier}, соответствующая переданному DTO
     */
    Courier toCourierFromCreateCourierDto(CreateCourierDto createCourierDto);
}
