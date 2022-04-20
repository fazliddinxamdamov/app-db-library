package com.fazliddin.library.repository;

import com.fazliddin.library.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Fazliddin Xamdamov
 * @date 19.04.2022  12:51
 * @project app-fast-food
 */
public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
