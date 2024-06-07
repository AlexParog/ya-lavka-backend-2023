package ru.shbr.ya_lavka2023.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Courier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private CourierTypeEnum movementType;
    private int area;
    private int loadCapacity;
    private String workingHours;

    public Courier(Long id, CourierTypeEnum movementType, int area, int loadCapacity, String workingHours) {
        this.id = id;
        this.movementType = movementType;
        this.area = area;
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    @Override
    public String toString() {
        return "Courier{" +
                "id=" + id +
                ", movementType=" + movementType +
                ", area=" + area +
                ", loadCapacity=" + loadCapacity +
                ", workingHours='" + workingHours + '\'' +
                '}';
    }
}
