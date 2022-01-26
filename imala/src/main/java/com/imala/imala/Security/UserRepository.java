package com.imala.imala.security;

import java.util.List;

import com.imala.imala.security.User.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);

    int countByRole(Role role);

    List<User> findByRole(Role role);

    
}
