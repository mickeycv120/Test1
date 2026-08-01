package com.mickey.test.customer.service;

import com.mickey.test.customer.dto.CreateCustomerRequest;
import com.mickey.test.customer.dto.CustomerResponse;
import com.mickey.test.customer.model.Customer;

import com.mickey.test.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    private CustomerResponse toResponse(Customer customer){
        return new CustomerResponse(
                customer.getId(),
                customer.getName(),
                customer.getAge(),
                customer.getEmail(),
                customer.getPostalCode()
        );
    }

    public CustomerResponse createCustomer(CreateCustomerRequest request){
        if (repository.existsByEmail(request.email())){
            throw new IllegalArgumentException("Email already exists!");
        }

        Customer customer = new Customer(
                request.name(),
                request.age(),
                request.email(),
                request.postalCode()
        );

        Customer savedCustomer = repository.save(customer);

        return toResponse(savedCustomer);
    }

    public CustomerResponse getCustomerById(UUID id){
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found!")
                );

        return toResponse(customer);
    }
}
