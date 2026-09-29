package com.rohan.payment_gateway.merchant.service.impl;

import com.rohan.payment_gateway.common.enums.MerchantStatus;
import com.rohan.payment_gateway.common.enums.UserRole;
import com.rohan.payment_gateway.common.exception.DuplicateResourceException;
import com.rohan.payment_gateway.merchant.dto.request.MerchantSignupRequest;
import com.rohan.payment_gateway.merchant.dto.response.MerchantResponse;
import com.rohan.payment_gateway.merchant.entity.AppUser;
import com.rohan.payment_gateway.merchant.entity.Merchant;
import com.rohan.payment_gateway.merchant.mapper.MerchantMapper;
import com.rohan.payment_gateway.merchant.repository.AppUserRepository;
import com.rohan.payment_gateway.merchant.repository.MerchantRepository;
import com.rohan.payment_gateway.merchant.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final MerchantRepository merchantRepository;
    private final AppUserRepository appUserRepository;
    private final MerchantMapper merchantMapper;

    @Override
    public MerchantResponse signup(MerchantSignupRequest request) {
        if (merchantRepository.existsByEmail(request.email())) {
            throw new DuplicateResourceException("DUPLICATE_MERCHANT_EMAIL", "Merchant with email already exists: " + request.email());
        }

        Merchant merchant = merchantMapper.toEntityFromSignUpRequest(request);

        merchant.setStatus(MerchantStatus.PENDING_KYC);
        merchant = merchantRepository.save(merchant);

        AppUser appUser = AppUser.builder()
                .email(merchant.getEmail())
                .merchant(merchant)
                .passwordHash(request.password())
                .role(UserRole.OWNER)
                .build();

        appUser = appUserRepository.save(appUser);

        return merchantMapper.toResponse(merchant);
    }
}
