package com.imala.imala.crosscountry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "crossdetails")
@Entity(name = "cross_country")
public class CrossCountry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "departure",
            nullable = false
        //     columnDefinition = "TEXT"
    )
    private String departure;

    @Column(
        name = "destination",
        nullable = false
        // columnDefinition = "TEXT"
)
    private String destination;

    @Column(
        name = "tariff",
        nullable = false
       
)
    private double tariff;

    @Column(
        name = "bus",
        nullable = false
      
)
    @Enumerated(EnumType.STRING)
    private Type bus;

    public static enum Type {
        ODA, SELAM, GHION, ABAY
    }

    public CrossCountry(String departure, String destination, double tariff, Type bus) {
        this.departure = departure;
        this.destination = destination;
        this.tariff = tariff;
        this.bus = bus;
    }


}



