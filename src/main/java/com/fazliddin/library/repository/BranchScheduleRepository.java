package com.fazliddin.library.repository;

import com.fazliddin.library.entity.BranchSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Fazliddin Xamdamov
 * @date 06.04.2022  14:33
 * @project app-fast-food
 */
@Repository
public interface BranchScheduleRepository extends JpaRepository<BranchSchedule, Long> {
    List<BranchSchedule> findAllByBranchId(Long branchId);
}
