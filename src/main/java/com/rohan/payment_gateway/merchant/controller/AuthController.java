package com.rohan.payment_gateway.merchant.controller;

import com.rohan.payment_gateway.merchant.dto.request.MerchantSignupRequest;
import com.rohan.payment_gateway.merchant.dto.response.MerchantResponse;
import com.rohan.payment_gateway.merchant.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<MerchantResponse> signup(@RequestBody MerchantSignupRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                authService.signup(request)
        );
    }

}
