package com.rohan.payment_gateway.merchant.service;

import com.rohan.payment_gateway.merchant.dto.request.CreateApiKeyRequest;
import com.rohan.payment_gateway.merchant.dto.response.ApiKeyCreateResponse;
import com.rohan.payment_gateway.merchant.dto.response.ApiKeyResponse;
import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public interface ApiKeyService {
    ApiKeyCreateResponse create(UUID merchantId, @Valid CreateApiKeyRequest request);

    List<ApiKeyResponse> listByMerchant(UUID merchantId);

    void revoke(UUID merchantId, UUID keyId);

    ApiKeyCreateResponse rotate(UUID merchantId, UUID keyId);
}
