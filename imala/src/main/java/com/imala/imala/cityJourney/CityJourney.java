package com.imala.imala.cityJourney;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

    @Column(name = "departure", nullable = false)
    private String departure;
   
    @Column(name="destination", nullable=false)
    private String destination;

    @Column(name = "tariff",nullable=false)
    private float tariff;
    
}
