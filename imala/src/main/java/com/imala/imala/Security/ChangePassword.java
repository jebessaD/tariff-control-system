package com.imala.imala.Security;



import lombok.Data;

@Data
public class ChangePassword {



    private String oldPassword;
    // @Pattern(regexp = "(?=.*?[0-9])(?=.*?[!@#&()-[{}]:;',?/*~$^+=<>])(?=.*?[a-z]).{6,10}",message = "Password must contain digit,alphabet and special character and should be 6 to 10 characters long")
    private String newPassword;
    
    
}
