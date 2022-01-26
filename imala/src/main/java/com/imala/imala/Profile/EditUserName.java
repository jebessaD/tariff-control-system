package com.imala.imala.Profile;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EditUserName {

    @NotBlank
    private String username;
    
}
