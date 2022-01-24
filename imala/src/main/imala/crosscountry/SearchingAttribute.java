package com.imala.imala.crosscountry;

import javax.validation.constraints.NotBlank;

// import javax.persistence.EnumType;
// import javax.persistence.Enumerated;

// import com.imala.imala.CrossCountry.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchingAttribute {

    @NotBlank
    private String departure;

    @NotBlank
    private String destination;  
    
    @NotBlank
    private String bus;


    
    
}
