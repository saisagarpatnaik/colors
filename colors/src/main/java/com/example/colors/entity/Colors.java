package com.example.colors.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Colors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int colorId;

    @Column
    private String color;

}
