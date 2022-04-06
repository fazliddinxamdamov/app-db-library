package com.fazliddin.library.repository;

import com.fazliddin.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Fazliddin Xamdamov
 * @date 06.04.2022  14:33
 * @project app-fast-food
 */
public interface UserRepo extends JpaRepository<User , Integer> {
}
