package com.rohan.payment_gateway.merchant.repository;

import com.rohan.payment_gateway.merchant.entity.ApiKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.server.CoWebFilterChain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ApiKeyRepository extends JpaRepository<ApiKey, Integer> {
    Optional<ApiKey> findById(UUID keyId);

    List<ApiKey> findByMerchant_Id(UUID merchantId);
}
