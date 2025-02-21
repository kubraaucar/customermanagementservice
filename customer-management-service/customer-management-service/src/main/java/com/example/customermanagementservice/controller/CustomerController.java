package com.example.customermanagementservice.controller;

import com.example.customermanagementservice.model.Customer;
import com.example.customermanagementservice.service.CustomerService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getAll")
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/getByName/{name}")
    public List<Customer> getByName(@PathVariable String name) {
        return customerService.getByName(name);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addCustomer(@Valid @RequestBody CustomerRequest customerRequestDTO) {
        Customer customer = customerService.addCustomer(customerRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> removeCustomer(@PathVariable("id") UUID customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{citizenNumber}")
    public ResponseEntity<Customer> updateActivation(@PathVariable("citizenNumber") long citizenNumber) {
        Customer customer = customerService.updateActivation(citizenNumber);
        return ResponseEntity.ok(customer);
    }

}
