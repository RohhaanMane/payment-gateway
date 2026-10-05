package com.rohan.payment_gateway.common.util;

import java.security.SecureRandom;
import java.util.Base64;

public class RandomizerUtil {
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public static String randomBase64(int length) {

        byte[] buf = new byte[length];
        SECURE_RANDOM.nextBytes(buf);
//        [4, 12, 100, -12] {-128, 127}
        return Base64.getUrlEncoder().withoutPadding().encodeToString(buf);
    }
}
