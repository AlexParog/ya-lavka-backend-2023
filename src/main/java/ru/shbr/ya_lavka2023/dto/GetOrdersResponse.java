package ru.shbr.ya_lavka2023.dto;

import java.util.List;

/**
 * Ответ при получении информации о всех заказах с поддержкой постраничной выдачи.
 *
 * @param orderDtos список объектов {@link OrderDto}, содержащих данные о заказах
 * @param offset    смещение для постраничной выдачи
 * @param limit     количество записей для постраничной выдачи
 */
public record GetOrdersResponse(List<OrderDto> orderDtos,
                                Integer offset,
                                Integer limit) {

    public static GetOrdersResponse.Builder builder() {
        return new GetOrdersResponse.Builder();
    }

    public static class Builder {
        private List<OrderDto> orders;
        private Integer offset;
        private Integer limit;

        public GetOrdersResponse.Builder orders(List<OrderDto> orders) {
            this.orders = orders;
            return this;
        }

        public GetOrdersResponse.Builder offset(Integer offset) {
            this.offset = offset;
            return this;
        }

        public GetOrdersResponse.Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public GetOrdersResponse build() {
            return new GetOrdersResponse(orders, offset, limit);
        }
    }
}
