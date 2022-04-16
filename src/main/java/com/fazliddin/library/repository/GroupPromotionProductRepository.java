package com.fazliddin.library.repository;

import com.fazliddin.library.entity.GroupPromotionProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Fazliddin Xamdamov
 * @date 06.04.2022  14:33
 * @project app-fast-food
 */
@Repository
public interface GroupPromotionProductRepository extends JpaRepository<GroupPromotionProduct, Long> {
}
