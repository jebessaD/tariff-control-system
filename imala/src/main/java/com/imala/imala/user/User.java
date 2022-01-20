package com.imala.imala.user;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;




@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class User implements UserDetails {

    private static final long serialVersionUID = 1L;

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
    private String username;
    
    @Column(
        name = "password",  
        nullable = false
    )
    private String password;
    
    @Column(
        name = "email",  
        nullable = false
    )
    private String email;

    public User(String name, String username, String passWord, String email){
        this.name = name;
        this.username = username;
        this.password = passWord;
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
    return true;
    }

    @Override
    public boolean isAccountNonLocked() {
    return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
    return true;
    }
    
    @Override
    public boolean isEnabled() {
    return true;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return password;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return username;
    }
        
    }
