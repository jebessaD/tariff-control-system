package com.imala.imala.Security;

import java.util.List;

import com.imala.imala.Security.User.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);

    int countByRole(Role role);

    List<User> findByRole(Role role);

    
}
