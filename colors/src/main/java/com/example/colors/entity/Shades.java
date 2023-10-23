package com.example.colors.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Shades {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shadeId;

	@Column
	private String shadeName;

	@ManyToOne // (cascade = CascadeType.PERSIST) //(fetch = FetchType.EAGER, cascade =
				// CascadeType.MERGE)
	@JoinColumn(name = "colorId")
	private Colors colors;

}
