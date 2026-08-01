package com.mickey.test.customer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateCustomerRequest(
        @NotBlank(message = "Name is required")
        String name,

        @NotNull(message = "Age is required")
        @Min(value=18,message = "Customer must be at least 18 years old")
        Integer age,

        @NotBlank(message = "Email is required")
        @Email(message = "Email format is invalid")
        String email,

        @NotBlank(message = "Postal code is required")
        String postalCode
) {
}
