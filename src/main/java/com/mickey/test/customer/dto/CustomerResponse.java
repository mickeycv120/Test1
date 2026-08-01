package com.mickey.test.customer.dto;

import java.util.UUID;

public record CustomerResponse(
        UUID id,
        String name,
        Integer age,
        String email,
        String postalCode
) {
}
