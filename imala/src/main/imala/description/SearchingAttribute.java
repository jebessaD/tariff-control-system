package com.imala.imala.description;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchingAttribute {
     

    @NotBlank
    private String code;

}

