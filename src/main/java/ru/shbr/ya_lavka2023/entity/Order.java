package ru.shbr.ya_lavka2023.entity;

import jakarta.persistence.*;

import java.util.Set;

/**
 * Сущность Заказ
 */
@Entity
@Table(name = "order")
public class Order {
    /**
     * Id заказа
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;
    /**
     * Вес заказа
     */
    @Column(name = "weight")
    private int weight;
    /**
     * Район
     */
    @Column(name = "area")
    private int area;
    /**
     * Промежутки времени, когда удобно доставить заказ
     */
    @ElementCollection
    @Column(name = "delivery_time")
    private Set<String> deliveryTime;
    /**
     * Цена заказ
     */
    @Column(name = "price")
    private int price;

    public Order() {
    }

    public Order(Long id, int weight, int area, Set<String> deliveryTime, int price) {
        this.id = id;
        this.weight = weight;
        this.area = area;
        this.deliveryTime = deliveryTime;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public Set<String> getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Set<String> deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", weight=" + weight +
                ", area=" + area +
                ", deliveryTime='" + deliveryTime + '\'' +
                ", price=" + price +
                '}';
    }
}
