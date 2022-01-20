package com.imala.imala.crosscountry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
// @Table(name= "crossdetails")
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

    @NotBlank
    private String departure;

    @Column(
        name = "destination",
        nullable = false
        // columnDefinition = "TEXT"
)   
    @NotBlank
    private String destination;

    @Column(
        name = "tariff",
        nullable = false
       
)

    @DecimalMin(value="1.0",inclusive=true)
    @Digits(integer=3,fraction=2)
    private double tariff;

    @Column(
        name = "bus",
        nullable = false
      
)
    @NotBlank
    private String bus;

    // public static enum Type {
    //     ODA, SELAM, GHION, ABAY
    // }

    public CrossCountry(String departure, String destination, double tariff, String bus) {
        this.departure = departure;
        this.destination = destination;
        this.tariff = tariff;
        this.bus = bus;
    }


}



