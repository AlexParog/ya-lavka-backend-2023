package ru.shbr.ya_lavka2023.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shbr.ya_lavka2023.entity.Courier;

@Repository
public interface CourierRepository extends JpaRepository<Courier, Long> {
    Page<Courier> findAll(Pageable pageable);
}
