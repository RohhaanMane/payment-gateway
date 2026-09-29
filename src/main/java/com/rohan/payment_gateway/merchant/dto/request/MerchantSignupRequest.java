package com.rohan.payment_gateway.merchant.dto.request;

import com.rohan.payment_gateway.common.enums.BusinessType;

public record MerchantSignupRequest(
    String name,
    String email,
    String password,
    String businessName,
    BusinessType businessType
) {
}
