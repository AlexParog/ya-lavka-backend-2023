package ru.shbr.ya_lavka2023.service.impl;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.shbr.ya_lavka2023.dto.*;
import ru.shbr.ya_lavka2023.entity.Courier;
import ru.shbr.ya_lavka2023.exception.BadRequestException;
import ru.shbr.ya_lavka2023.exception.NotFoundException;
import ru.shbr.ya_lavka2023.mapper.CourierMapper;
import ru.shbr.ya_lavka2023.repository.CourierRepository;
import ru.shbr.ya_lavka2023.service.CourierPaginationRequest;
import ru.shbr.ya_lavka2023.service.CourierService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Реализация {@link CourierService}
 */
@Service
public class CourierServiceImpl implements CourierService {
    private final CourierRepository courierRepository;
    private final CourierMapper courierMapper;

    /**
     * Конструктор
     *
     * @param courierRepository репозиторий курьера
     * @param courierMapper     маппер для сущности Курьер
     */
    public CourierServiceImpl(CourierRepository courierRepository, CourierMapper courierMapper) {
        this.courierRepository = courierRepository;
        this.courierMapper = courierMapper;
    }

    @Override
    public CreateCouriersResponse saveCouriers(CreateCourierRequest couriers) {
        List<CreateCourierDto> createCourierDtos = couriers.couriers(); // необходимо валидация на заполнение данных
        List<Courier> savedCouriers = new ArrayList<>();

        for (CreateCourierDto dto : createCourierDtos) {
            Courier courier = courierMapper.toCourierFromCreateCourierDto(dto);
            savedCouriers.add(courier);
        }
        courierRepository.saveAll(savedCouriers);

        List<CourierDto> courierDtos = savedCouriers
                .stream()
                .map(courierMapper::toCourierDto)
                .toList();

        return new CreateCouriersResponse(courierDtos);
    }

    @Override
    public CourierDto getCourierById(Long id) {
        return courierMapper.toCourierDto(findCourierOrNotFound(id));
    }

    @Override
    public void deleteCourierById(Long id) {
        courierRepository.deleteById(id);
    }

    @Override
    public GetCouriersResponse findCouriers(Integer offset, Integer limit) {
        if (Objects.equals(limit, offset)) {
            throw new BadRequestException(
                    String.format("Параметры offset=%d и limit=%d не могут быть равны", offset, limit));
        }

        List<Courier> couriers = courierRepository.findAll(new CourierPaginationRequest(offset, limit, Sort.unsorted()))
                .stream()
                .toList();

        return GetCouriersResponse.builder()
                .couriers(couriers
                        .stream()
                        .map(courierMapper::toCourierDto)
                        .toList())
                .offset(offset)
                .limit(limit)
                .build();
    }

    /**
     * Находим по id курьера или возвращаем информацию NotFound
     *
     * @param id идентификатор курьера
     * @return сущность {@link Courier} или ошибку {@link NotFoundException}
     */
    private Courier findCourierOrNotFound(Long id) {
        return courierRepository.findById(id).orElseThrow(
                () -> new NotFoundException(String.format("Courier с id=%d не найден!", id)));
    }
}
