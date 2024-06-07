package ru.shbr.ya_lavka2023.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shbr.ya_lavka2023.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
