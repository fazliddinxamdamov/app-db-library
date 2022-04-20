package com.fazliddin.library.repository;

import com.fazliddin.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Fazliddin Xamdamov
 * @date 06.04.2022  14:33
 * @project app-fast-food
 */
@Repository
public interface UserRepository extends JpaRepository<User , UUID> {
    Optional<User> findByPhoneNumber(String username);
}