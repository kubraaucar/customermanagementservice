package com.example.customermanagementservice.service;

import com.example.customermanagementservice.controller.CustomerRequest;
import com.example.customermanagementservice.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    List<Customer> getAll();
    List<Customer> getByName(String name);

    Customer addCustomer(CustomerRequest customerRequestDTO);

    void deleteCustomer(UUID customerId);

    Customer updateActivation(long citizenNumber);


}
