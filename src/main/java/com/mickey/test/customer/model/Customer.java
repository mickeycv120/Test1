package com.mickey.test.customer.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table (name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(name = "postal_code", nullable = false)
    private String postalCode;
}
