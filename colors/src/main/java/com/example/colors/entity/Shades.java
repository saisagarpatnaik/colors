package com.example.colors.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Shades{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shadeId;

    @Column
    private String shadeName;

    @ManyToOne //(cascade = CascadeType.PERSIST) //(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "colorId")
    private Colors colors;

}
