package ru.shbr.ya_lavka2023.service;

import ru.shbr.ya_lavka2023.dto.CourierDto;
import ru.shbr.ya_lavka2023.dto.CreateCourierRequest;
import ru.shbr.ya_lavka2023.dto.CreateCouriersResponse;
import ru.shbr.ya_lavka2023.dto.GetCouriersResponse;
import ru.shbr.ya_lavka2023.entity.Courier;
import ru.shbr.ya_lavka2023.exception.NotFoundException;

/**
 * Сервис Курьеров
 */
public interface CourierService {

    /**
     * Загрузка в формате json и сохранение информации о курьерах и их графиков работы.
     *
     * @param couriers dto для создания списка курьеров
     * @return {@link CreateCouriersResponse} dto, содержащее список курьеров
     */
    CreateCouriersResponse saveCouriers(CreateCourierRequest couriers);

    /**
     * Возвращает информацию о курьере по id.
     *
     * @param id идентификатор курьера
     * @return {@link CourierDto} dto курьера
     */
    CourierDto getCourierById(Long id);

    /**
     * Удаление курьера по id.
     *
     * @param id идентификатор курьера
     */
    void deleteCourierById(Long id);

    /**
     * Возвращает информацию о всех курьерах с поддержкой постраничной выдачи.
     * <p>
     * Если параметры {@code offset} или {@code limit} не переданы, используются значения по умолчанию:
     * {@code offset = 0}, {@code limit = 1}.
     * <p>
     * Если по заданным {@code offset} и {@code limit} не найдено ни одного курьера, возвращается пустой список.
     *
     * @param offset смещение для постраничной выдачи (может быть {@code null}, тогда используется значение
     *               по умолчанию {@code 0})
     * @param limit  количество записей для постраничной выдачи (может быть {@code null}, тогда используется
     *               значение по умолчанию {@code 1})
     * @return {@link GetCouriersResponse} объект, содержащий список курьеров и информацию о постраничной выдаче
     */
    GetCouriersResponse findCouriers(Integer offset, Integer limit);

    /**
     * Находим по id курьера или возвращаем информацию NotFound
     *
     * @param id идентификатор курьера
     * @return сущность {@link Courier} или ошибку {@link NotFoundException}
     */
    Courier findCourierOrNotFound(Long id);
}
