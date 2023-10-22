package com.example.colors.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @Column
    private String customerName;
    @Column
    private String customerAddress;
    @Column
    private String customerPhoneNumber;

}
