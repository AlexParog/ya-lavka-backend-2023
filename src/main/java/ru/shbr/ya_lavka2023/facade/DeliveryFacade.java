package ru.shbr.ya_lavka2023.facade;

import ru.shbr.ya_lavka2023.dto.CourierDto;
import ru.shbr.ya_lavka2023.dto.CreateCourierRequest;
import ru.shbr.ya_lavka2023.dto.CreateCouriersResponse;
import ru.shbr.ya_lavka2023.dto.GetCouriersResponse;

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

    //CreateOrderResponse saveOrders(CreateOrderRequest createOrderRequest);

    //OrderDto getOrderById(Long orderId);

    //List<OrderDto> getOrders(Integer offset, Integer limit);

    //List<OrderDto> saveCompletedOrders(CompleteOrderRequestDto completeOrderRequestDto);
}
