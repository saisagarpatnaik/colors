package com.example.colors.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @Column
    private int orderQuantity;

    @Column
    private String orderDate;

    @PrePersist
    public void prePersist() {
        // This method will be called before the entity is persisted (created).
        orderDate = LocalDateTime.now().toString();
    }
    @PreUpdate
    public void preUpdate() {
        // This method will be called before the entity is updated.
        orderDate = LocalDateTime.now().toString();
    }

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "colorId")
    private Colors colors;

    @ManyToOne
    @JoinColumn(name = "shadeId")
    private Shades shades;
}
