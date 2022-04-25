package com.fazliddin.library.repository;

import com.fazliddin.library.entity.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Fazliddin Xamdamov
 * @date 06.04.2022  14:33
 * @project app-fast-food
 */
public interface VerificationCodeRepository extends JpaRepository<VerificationCode, UUID> {
    List<VerificationCode> findAllByCreatedAtAfterOrderByCreatedAt(Timestamp timestamp);

    @Query("select v from VerificationCode v where v.phoneNumber = ?1 and v.code = ?2 and v.expireTime > ?3 and v.used=false")
    Optional<VerificationCode> checkVerificationCode(String phoneNumber, String verificationCode, Timestamp timestamp);
}
