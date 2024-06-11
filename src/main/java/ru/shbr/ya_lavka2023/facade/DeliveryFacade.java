package ru.shbr.ya_lavka2023.facade;

import ru.shbr.ya_lavka2023.dto.*;

import java.util.List;

/**
 * Унифицированный интерфейс для управления интерфейсами Курьеров и Заказов (паттерн Facade)
 */
public interface DeliveryFacade {
    /**
     * Загрузка в формате json и сохранение информации о курьерах и их графиков работы.
     *
     * @param courierRequest dto списка курьеров для создания
     * @return {@link CreateCouriersResponse} dto, содержащее список курьеров
     */
    CreateCouriersResponse saveCouriers(CreateCourierRequest courierRequest);

    /**
     * Возвращает информацию о курьере по id.
     *
     * @param courierId id курьера
     * @return {@link CourierDto} dto курьера
     */
    CourierDto getCourierById(Long courierId);

    /**
     * Возвращает информацию о всех курьерах с поддержкой постраничной выдачи.
     * <p>
     * Если параметры {@code offset} или {@code limit} не переданы, используются значения по умолчанию:
     * {@code offset = 0}, {@code limit = 1}.
     * <p>
     * Если по заданным {@code offset} и {@code limit} не найдено ни одного курьера, возвращается пустой список.
     *
     * @param offset смещение для постраничной выдачи (может быть {@code null}, тогда используется значение по умолчанию {@code 0})
     * @param limit  количество записей для постраничной выдачи (может быть {@code null}, тогда используется значение по умолчанию {@code 1})
     * @return {@link GetCouriersResponse} объект, содержащий список курьеров и информацию о постраничной выдаче
     */
    GetCouriersResponse getAllCouriers(Integer offset, Integer limit);

    /**
     * Удаление курьера по id.
     *
     * @param courierId id курьера
     */
    void deleteCourier(Long courierId);

    // GetCourierMetaInfoResponse getCourierMetaInfo(Long courierId, String startDate, String endDate);

    /**
     * Загрузка в формате json и сохранение информации о заказах.
     *
     * @param createOrderRequest dto для создания списка заказов
     * @return {@link CreateCouriersResponse} dto, содержащее список заказов
     */
    CreateOrderResponse saveOrders(CreateOrderRequest createOrderRequest);

    /**
     * Возвращает информацию о заказе по id.
     *
     * @param orderId id заказа
     * @return {@link OrderDto} dto заказа
     */
    OrderDto getOrder(Long orderId);

    /**
     * Получает информацию о всех заказах с поддержкой постраничной выдачи.
     * <p>
     * Если параметры {@code offset} или {@code limit} не переданы, используются значения по умолчанию:
     * {@code offset = 0}, {@code limit = 1}.
     * <p>
     * Если по заданным {@code offset} и {@code limit} не найдено ни одного заказа, возвращается пустой список.
     *
     * @param offset смещение для постраничной выдачи (по умолчанию 0)
     * @param limit  количество записей для постраничной выдачи (по умолчанию 1)
     * @return {@link GetOrdersResponse} объект, содержащий список заказов и информацию о постраничной выдаче
     */
    GetOrdersResponse getAllOrders(Integer offset, Integer limit);

    /**
     * Завершает один или несколько заказов.
     *
     * @param completeOrderRequestDto запрос с информацией о завершении заказов
     * @return список объектов {@link OrderDto}, содержащих данные о завершенных заказах
     */
    List<OrderDto> saveCompletedOrders(CompleteOrderRequestDto completeOrderRequestDto);
}
