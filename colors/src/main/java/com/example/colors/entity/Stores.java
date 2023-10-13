package com.example.colors.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Stores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int storeNo;

    @Column
    private String storeAddress;

}
