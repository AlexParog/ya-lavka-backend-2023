package ru.shbr.ya_lavka2023.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.web.bind.annotation.*;
import ru.shbr.ya_lavka2023.dto.*;
import ru.shbr.ya_lavka2023.facade.DeliveryFacade;

import java.util.List;

/**
 * REST контроллер для управления заказами.
 * <p>
 * Предоставляет методы для создания новых заказов, получения информации о заказах,
 * получения списка всех заказов с поддержкой постраничной выдачи и завершения заказов.
 */
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final DeliveryFacade deliveryFacade;

    /**
     * Конструктор контроллера заказов.
     *
     * @param deliveryFacade фасад, используемый для выполнения операций с заказами
     */
    public OrderController(DeliveryFacade deliveryFacade) {
        this.deliveryFacade = deliveryFacade;
    }

    /**
     * Создает новые заказы.
     *
     * @param createOrderRequest запрос с данными для создания заказов
     * @return {@link CreateOrderResponse} объект с результатами создания заказов
     */
    @PostMapping
    public CreateOrderResponse saveNewOrders(@RequestBody CreateOrderRequest createOrderRequest) {
        return deliveryFacade.saveOrders(createOrderRequest);
    }

    /**
     * Получает информацию о заказе по его идентификатору.
     *
     * @param orderId идентификатор заказа
     * @return {@link OrderDto} объект, содержащий данные о заказе
     */
    @GetMapping("/{orderId}")
    public OrderDto getOrder(@PathVariable Long orderId) {
        return deliveryFacade.getOrder(orderId);

    }

    /**
     * Получает информацию о всех заказах с поддержкой постраничной выдачи.
     * <p>
     * Если параметры {@code offset} или {@code limit} не переданы, используются значения по умолчанию:
     * {@code offset = 0}, {@code limit = 1}.
     * <p>
     * Если по заданным {@code offset} и {@code limit} не найдено ни одного заказа, возвращается пустой список.
     *
     * @param offset смещение для постраничной выдачи (по умолчанию 0)
     * @param limit  количество записей для постраничной выдачи (по умолчанию 1, минимально 1, максимально 20)
     * @return {@link GetOrdersResponse} объект, содержащий список заказов и информацию о постраничной выдаче
     */
    @GetMapping
    public GetOrdersResponse getAllOrders(@PositiveOrZero @RequestParam(defaultValue = "0") int offset,
                                          @Positive @RequestParam(defaultValue = "1") @Min(1) @Max(20) int limit) {
        return deliveryFacade.getAllOrders(offset, limit);
    }

    /**
     * Завершает один или несколько заказов.
     *
     * @param completeOrderRequestDto запрос с информацией о завершении заказов
     * @return список объектов {@link OrderDto}, содержащих данные о завершенных заказах
     */
    @PostMapping("/complete")
    public List<OrderDto> saveCompleteOrders(@RequestBody @Valid CompleteOrderRequestDto completeOrderRequestDto) {
        return deliveryFacade.saveCompletedOrders(completeOrderRequestDto);
    }
}
