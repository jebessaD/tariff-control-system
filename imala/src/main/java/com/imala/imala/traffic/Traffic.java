package com.imala.imala.traffic;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Traffic {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
        name = "name",  
        nullable = false
    )
    private String name;
    
    @Column(
        name = "username",  
        nullable = false
    )
    private String userName;
    
    @Column(
        name = "password",  
        nullable = false
    )
    private String passWord;
    
    @Column(
        name = "email",  
        nullable = false
    )
    private String email;

}
