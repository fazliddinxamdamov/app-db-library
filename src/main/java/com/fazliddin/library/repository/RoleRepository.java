package com.fazliddin.library.repository;

import com.fazliddin.library.entity.Role;
import com.fazliddin.library.enums.RoleTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Fazliddin Xamdamov
 * @date 18.04.2022  15:51
 * @project app-fast-food
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleType(RoleTypeEnum user);
}
