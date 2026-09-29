package com.rohan.payment_gateway.merchant.service;

import com.rohan.payment_gateway.merchant.dto.request.MerchantSignupRequest;
import com.rohan.payment_gateway.merchant.dto.response.MerchantResponse;

public interface AuthService {
    MerchantResponse signup(MerchantSignupRequest request);
}
