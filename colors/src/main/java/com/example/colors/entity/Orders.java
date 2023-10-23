package com.example.colors.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
