package ru.shbr.ya_lavka2023.dto;

import java.util.List;

/**
 * Ответ при получении информации о всех курьерах с поддержкой постраничной выдачи.
 *
 * @param couriers список объектов {@link CourierDto}, содержащих данные о курьерах
 * @param offset   смещение для постраничной выдачи
 * @param limit    количество записей для постраничной выдачи
 */
public record GetCouriersResponse(List<CourierDto> couriers,
                                  Integer offset,
                                  Integer limit) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<CourierDto> couriers;
        private Integer offset;
        private Integer limit;

        public Builder couriers(List<CourierDto> couriers) {
            this.couriers = couriers;
            return this;
        }

        public Builder offset(Integer offset) {
            this.offset = offset;
            return this;
        }

        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public GetCouriersResponse build() {
            return new GetCouriersResponse(couriers, offset, limit);
        }
    }
}
