package com.imala.imala.Profile;


import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class EditProfile {

    private String oldPassword;

    @Pattern(regexp = "(?=.*?[0-9])(?=.*?[!@#&()-[{}]:;',?/*~$^+=<>])(?=.*?[a-z]).{6,10}",message = "Password must contain digit,alphabet and special character and shuold be 6 to 10 cahraters long")
    private String newPassword;

  
    
}
