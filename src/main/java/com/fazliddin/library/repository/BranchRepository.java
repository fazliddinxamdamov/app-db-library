package com.fazliddin.library.repository;

import com.fazliddin.library.entity.Branch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Fazliddin Xamdamov
 * @date 06.04.2022  14:33
 * @project app-fast-food
 */
@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {
    Page<Branch> findAllByRegionId(PageRequest pageRequest, Long regionId);

    Page<Branch> findAllByDistrictId(PageRequest pageRequest, Long districtId);
}
