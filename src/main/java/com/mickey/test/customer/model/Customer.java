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

    protected Customer() {}

    public Customer(String name, Integer age, String email, String postalCode) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.postalCode = postalCode;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
