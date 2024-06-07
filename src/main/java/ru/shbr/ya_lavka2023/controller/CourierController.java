package ru.shbr.ya_lavka2023.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shbr.ya_lavka2023.dto.CourierDto;
import ru.shbr.ya_lavka2023.entity.Courier;
import ru.shbr.ya_lavka2023.service.CourierService;

import java.util.List;

@RestController
@RequestMapping("/couriers")
public class CourierController {
    private final CourierService courierService;

    public CourierController(CourierService courierService) {
        this.courierService = courierService;
    }

    @PostMapping
    public ResponseEntity<Courier> addCouriers(@RequestBody List<CourierDto> couriers) {
        courierService.createCouriers(couriers);
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Courier> getCourier(@PathVariable Long id) {
        courierService.getCourierById(id);
        return null;
    }

    @GetMapping
    public ResponseEntity<Courier> getAllCouriers(@RequestParam(defaultValue = "0") int offset,
                                                  @RequestParam(defaultValue = "1") int limit) {
        courierService.getAllCouriers(offset, limit);
        return null;
    }
}
