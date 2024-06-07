package ru.shbr.ya_lavka2023.service.impl;

import ru.shbr.ya_lavka2023.dto.CourierDto;
import ru.shbr.ya_lavka2023.entity.Courier;
import ru.shbr.ya_lavka2023.service.CourierService;

import java.util.List;

public class CourierServiceImpl implements CourierService {
    @Override
    public List<Courier> createCouriers(List<CourierDto> courierDtos) {
        List<Courier> couriers =
    }

    @Override
    public Courier getCourierById(Long id) {
        return null;
    }

    @Override
    public List<Courier> getAllCouriers(int offset, int limit) {
        return null;
    }
}
