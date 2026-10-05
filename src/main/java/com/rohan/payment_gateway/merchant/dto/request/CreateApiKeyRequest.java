package com.rohan.payment_gateway.merchant.dto.request;

import com.rohan.payment_gateway.common.enums.Environment;

public record CreateApiKeyRequest(
        Environment environment
) {
}
