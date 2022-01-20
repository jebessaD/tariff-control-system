package com.imala.imala.description;

// import java.sql.Time;
// import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;
// import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "description")
public class Description {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    
    @NotBlank
    @Column(name="code")
    // @Size(min=5,max=6)
    
    private String code;
    // @Column(
    //     name = "date",
    //     nullable = false
    // //     columnDefinition = "TEXT"
    // )
    // private String date;

    // @Column(
    //     name = "time",
    //     nullable = false
    // //     columnDefinition = "TEXT"
    // )
    // private String time;
    @NotBlank
    @Column(
        name = "place"
        ,nullable = false
    //     columnDefinition = "TEXT"
    )
  
    private String place;

    @NotBlank
    @Column(
        name = "message",
        nullable = false
    //     columnDefinition = "TEXT"
    )
    private String message;

    // public Description(String code,String place,String message)

}
