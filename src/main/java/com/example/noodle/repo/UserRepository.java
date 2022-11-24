package com.example.noodle.repo;

import com.example.noodle.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long > {
    User findUserByUsernme(String username);
}
