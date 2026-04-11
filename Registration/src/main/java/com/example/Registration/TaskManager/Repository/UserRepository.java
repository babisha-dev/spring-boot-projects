package com.example.Registration.TaskManager.Repository;

import com.example.Registration.TaskManager.Modal.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUserEmail(String userEmail);
    Boolean existsByUserEmail(String userEmail);
}
