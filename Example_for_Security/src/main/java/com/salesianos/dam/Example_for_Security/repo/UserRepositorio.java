package com.salesianos.dam.Example_for_Security.repo;

import com.salesianos.dam.Example_for_Security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepositorio extends JpaRepository<User, UUID> {
    Optional<User> findFirstByUsername(String username);
}
