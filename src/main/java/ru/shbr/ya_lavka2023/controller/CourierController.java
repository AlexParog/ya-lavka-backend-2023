package ru.shbr.ya_lavka2023.controller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.web.bind.annotation.*;
import ru.shbr.ya_lavka2023.dto.CourierDto;
import ru.shbr.ya_lavka2023.dto.CreateCourierRequest;
import ru.shbr.ya_lavka2023.dto.CreateCouriersResponse;
import ru.shbr.ya_lavka2023.dto.GetCouriersResponse;
import ru.shbr.ya_lavka2023.facade.DeliveryFacade;

/**
 * REST контроллер для управления курьерами.
 * <p>
 * Предоставляет методы для создания, получения информации о конкретном курьере
 * и получения списка всех курьеров с поддержкой постраничной выдачи.
 */
@RestController
@RequestMapping("/couriers")
public class CourierController {

    private final DeliveryFacade deliveryFacade;

    /**
     * Конструктор контроллера.
     *
     * @param deliveryFacade фасад для управления курьерами
     */
    public CourierController(DeliveryFacade deliveryFacade) {
        this.deliveryFacade = deliveryFacade;
    }

    /**
     * Создает одного или нескольких курьеров.
     *
     * @param courierRequest запрос с данными для создания курьеров
     * @return {@link CreateCouriersResponse} объект с результатами создания курьеров
     */
    @PostMapping
    public CreateCouriersResponse saveCouriers(@RequestBody CreateCourierRequest courierRequest) {
        return deliveryFacade.saveCouriers(courierRequest);
    }

    /**
     * Возвращает информацию о курьере по его идентификатору.
     *
     * @param courierId идентификатор курьера
     * @return {@link CourierDto} объект с данными курьера
     */
    @GetMapping("/{courierId}")
    public CourierDto getCourier(@PathVariable Long courierId) {
        return deliveryFacade.getCourierById(courierId);
    }

    /**
     * Возвращает информацию о всех курьерах с поддержкой постраничной выдачи.
     * <p>
     * Если параметры {@code offset} или {@code limit} не переданы, используются значения по умолчанию:
     * {@code offset = 0}, {@code limit = 1}.
     * <p>
     * Если по заданным {@code offset} и {@code limit} не найдено ни одного курьера, возвращается пустой список.
     *
     * @param offset смещение для постраничной выдачи (по умолчанию 0)
     * @param limit  количество записей для постраничной выдачи (по умолчанию 1)
     * @return {@link GetCouriersResponse} объект, содержащий список курьеров и информацию о постраничной выдаче
     */
    @GetMapping
    public GetCouriersResponse getAllCouriers(@PositiveOrZero @RequestParam(defaultValue = "0") int offset,
                                              @Positive @RequestParam(defaultValue = "1") @Min(1) @Max(20) int limit) {
        return deliveryFacade.getAllCouriers(offset, limit);
    }

    /**
     * Удаляет курьера по идентификатору
     *
     * @param courierId идентификатор курьера
     */
    @DeleteMapping("/{courierId}")
    public void deleteCourier(@PathVariable Long courierId) {
        deliveryFacade.deleteCourier(courierId);
    }
}
