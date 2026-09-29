package com.rohan.payment_gateway.merchant.repository;

import com.rohan.payment_gateway.merchant.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppUserRepository extends JpaRepository<AppUser, UUID> {
}
