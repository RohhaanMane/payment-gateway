package com.rohan.payment_gateway.merchant.entity;

import com.rohan.payment_gateway.common.enums.Environment;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "api_key")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiKey {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "merchant_id", nullable = false)
    private Merchant merchant;

    @Column(nullable = false, length = 50, unique = true)
    private String keyId;

    @Column(nullable = false, length = 200)
    private String keySecretHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Environment environment;

    @Column(nullable = false)
    @Builder.Default
    private boolean enabled = true;


    private java.time.LocalDateTime lastUsedAt;
    private java.time.LocalDateTime rotatedAt;
    private java.time.LocalDateTime gracePeriodExpiresAt;
}
