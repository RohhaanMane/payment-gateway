package com.rohan.payment_gateway.merchant.dto.response;

import com.rohan.payment_gateway.common.enums.BusinessType;
import com.rohan.payment_gateway.common.enums.MerchantStatus;

import java.util.UUID;

public record MerchantResponse(
    UUID id,
    String name,
    String email,
    String businessName,
    BusinessType businessType,
    MerchantStatus merchantStatus
) {
}
