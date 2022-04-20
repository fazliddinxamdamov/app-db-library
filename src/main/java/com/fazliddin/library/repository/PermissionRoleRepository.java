package com.fazliddin.library.repository;

import com.fazliddin.library.entity.PermissionRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Fazliddin Xamdamov
 * @date 19.04.2022  09:09
 * @project app-fast-food
 */
public interface PermissionRoleRepository extends JpaRepository<PermissionRole , Long> {
    List<PermissionRole> findAllByRoleId(Long id);
}
