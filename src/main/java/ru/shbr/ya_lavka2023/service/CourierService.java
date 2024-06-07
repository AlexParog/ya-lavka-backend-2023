package ru.shbr.ya_lavka2023.service;

import org.springframework.stereotype.Service;
import ru.shbr.ya_lavka2023.dto.CourierDto;
import ru.shbr.ya_lavka2023.entity.Courier;

import java.util.List;

@Service
public interface CourierService {

    List<Courier> createCouriers(List<CourierDto> couriers);

    Courier getCourierById(Long id);

    List<Courier> getAllCouriers(int offset, int limit);
}
