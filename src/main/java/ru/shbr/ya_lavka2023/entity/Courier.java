package ru.shbr.ya_lavka2023.entity;

import jakarta.persistence.*;

import java.util.Set;

/**
 * Сущность Курьер
 */
@Entity
@Table(name = "courier")
public class Courier {
    /**
     * Id курьера
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    /**
     * Тип передвижения курьера
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "movement_type")
    private CourierTypeEnum movementType;
    /**
     * Принадлежность району
     */
    @ElementCollection
    @Column(name = "areas")
    private Set<Integer> areas;
    /**
     * Грузоподъемность
     */
    @Column(name = "load_capacity")
    private int loadCapacity;
    /**
     * Промежутки работы
     */
    @ElementCollection
    @Column(name = "working_hours")
    private Set<String> workingHours;

    public Courier(Long id, CourierTypeEnum movementType, Set<Integer> areas, int loadCapacity, Set<String> workingHours) {
        this.id = id;
        this.movementType = movementType;
        this.areas = areas;
        this.loadCapacity = loadCapacity;
        this.workingHours = workingHours;
    }

    public Courier() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CourierTypeEnum getMovementType() {
        return movementType;
    }

    public void setMovementType(CourierTypeEnum movementType) {
        this.movementType = movementType;
    }

    public Set<Integer> getAreas() {
        return areas;
    }

    public void setArea(Set<Integer> areas) {
        this.areas = areas;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public Set<String> getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Set<String> workingHours) {
        this.workingHours = workingHours;
    }

    @Override
    public String toString() {
        return "Courier{" +
                "id=" + id +
                ", movementType=" + movementType +
                ", areas=" + areas +
                ", loadCapacity=" + loadCapacity +
                ", workingHours='" + workingHours + '\'' +
                '}';
    }
}
