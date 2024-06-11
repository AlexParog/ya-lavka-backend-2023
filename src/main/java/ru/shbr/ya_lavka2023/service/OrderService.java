package ru.shbr.ya_lavka2023.service;

import ru.shbr.ya_lavka2023.dto.CreateOrderRequest;
import ru.shbr.ya_lavka2023.dto.CreateOrderResponse;
import ru.shbr.ya_lavka2023.dto.GetOrdersResponse;
import ru.shbr.ya_lavka2023.dto.OrderDto;
import ru.shbr.ya_lavka2023.entity.Order;
import ru.shbr.ya_lavka2023.exception.NotFoundException;

/**
 * Сервис Заказов
 */
public interface OrderService {
    /**
     * Загрузка в формате json и сохранение информации о заказах
     *
     * @param createOrderRequest dto для создания списка заказов
     * @return {@link CreateOrderResponse} dto, содержащее список курьеров
     */
    CreateOrderResponse saveOrders(CreateOrderRequest createOrderRequest);

    /**
     * Возвращает информацию о заказе по id.
     *
     * @param orderId идентификатор заказа
     * @return {@link OrderDto} dto заказа
     */
    OrderDto getOrderById(Long orderId);

    /**
     * Возвращает информацию о всех заказах с поддержкой постраничной выдачи.
     * <p>
     * Если параметры {@code offset} или {@code limit} не переданы, используются значения по умолчанию:
     * {@code offset = 0}, {@code limit = 1}.
     * <p>
     * Если по заданным {@code offset} и {@code limit} не найдено ни одного заказа, возвращается пустой список.
     *
     * @param offset смещение для постраничной выдачи (может быть {@code null}, тогда используется значение
     *               по умолчанию {@code 0})
     * @param limit  количество записей для постраничной выдачи (может быть {@code null}, тогда используется
     *               значение по умолчанию {@code 1})
     * @return {@link GetOrdersResponse} объект, содержащий список заказов и информацию о постраничной выдаче
     */
    GetOrdersResponse findOrders(Integer offset, Integer limit);

    /**
     * Находим по id заказа или возвращаем информацию NotFound
     *
     * @param id идентификатор заказа
     * @return сущность {@link Order} или ошибку {@link NotFoundException}
     */
    Order findOrderOrNotFound(Long id);
}
