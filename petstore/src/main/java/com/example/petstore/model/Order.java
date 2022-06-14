package com.example.petstore.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "orders")
@EntityListeners(AuditingEntityListener.class)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Pet petId;

    @Column(name = "quantity")
    private long quantity;

    @Column(name = "shipDate")
    private Timestamp shipDate;

    @Column(name = "status")
    private OrderStatus status;

    @Column(name = "complete")
    private boolean complete;

    public Order() {
    }

    public Order(Pet petId, long quantity, Timestamp shipDate, OrderStatus status, boolean complete) {
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
        this.status = status;
        this.complete = complete;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Pet getPetId() {
        return petId;
    }

    public void setPetId(Pet petId) {
        this.petId = petId;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Timestamp getShipDate() {
        return shipDate;
    }

    public void setShipDate(Timestamp shipDate) {
        this.shipDate = shipDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
