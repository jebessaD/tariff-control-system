package com.imala.imala.crosscountry;

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
    private String departure;
    private String destination;   
    private String bus;

  
    
}
