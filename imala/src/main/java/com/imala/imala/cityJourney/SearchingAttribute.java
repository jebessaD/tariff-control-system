package com.imala.imala.cityJourney;

import javax.validation.constraints.NotBlank;


import lombok.Data;

@Data
public class SearchingAttribute {

    @NotBlank
    private String departure;

    @NotBlank
    private String destination;   
    
}
