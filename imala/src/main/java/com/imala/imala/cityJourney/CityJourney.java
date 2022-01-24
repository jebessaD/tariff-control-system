package com.imala.imala.cityJourney;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "city_journey")
@AllArgsConstructor
@NoArgsConstructor
public class CityJourney {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(name = "departure")
    private String departure;
    
    @NotBlank
    @Column(name="destination", nullable=false)
    private String destination;

    @DecimalMin(value="1.0",inclusive=true)
    @Digits(integer=3,fraction=2)
    @Column(name = "tariff",nullable=false)
    private float tariff;
    
}
