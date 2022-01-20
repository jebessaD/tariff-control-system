package com.imala.imala.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    
    User findByUsername(String username);
}
