package com.mickey.test.customer.controller;

import com.mickey.test.customer.dto.CreateCustomerRequest;
import com.mickey.test.customer.dto.CustomerResponse;
import com.mickey.test.customer.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(@Valid @RequestBody CreateCustomerRequest request){
        CustomerResponse response = customerService.createCustomer(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(
            @PathVariable UUID id
    ) {
        CustomerResponse response = customerService.getCustomerById(id);

        return ResponseEntity.ok(response);
    }
}
