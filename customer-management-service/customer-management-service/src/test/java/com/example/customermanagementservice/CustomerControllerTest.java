package com.example.customermanagementservice;

import com.example.customermanagementservice.controller.CustomerController;
import com.example.customermanagementservice.controller.CustomerRequest;
import com.example.customermanagementservice.model.Customer;
import com.example.customermanagementservice.service.impl.CustomerServiceImpl;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CustomerControllerTest {
    @Mock
    private CustomerServiceImpl customerService;

    @InjectMocks
    private CustomerController controller;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllCustomer_when_givenValidRequest_then_returnSuccess(){
        Customer expected = new Customer();
        expected.setCitizenNumber(1234);

        when(customerService.getAll()).thenReturn(List.of(expected));
        List<Customer> actual = controller.getAll();
        assertEquals(expected,actual.get(0));

    }

    @Test
    void getByName_givenValidRequest_then_returnSuccess(){
        Customer expected = new Customer();
        expected.setCitizenNumber(1234);

        when(customerService.getByName("kubra")).thenReturn(List.of(expected));
        List<Customer> actual = controller.getByName("kubra");
        assertEquals(expected,actual.get(0));

    }

    @Test
    void add_givenValidRequest_then_returnSuccess(){
        Customer expected =new Customer();
        expected.setCitizenNumber(1234);
        CustomerRequest request = new CustomerRequest();
        request.setCitizenNumber(1234);

        when(customerService.addCustomer(request)).thenReturn(expected);
        ResponseEntity<Object> customerResponseEntity = controller.addCustomer(request);
        assertEquals(expected,customerResponseEntity.getBody());
    }

    @Test
    void remove_givenValidRequest_then_returnSuccess(){
        UUID customerId = UUID.randomUUID();

        doNothing().when(customerService).deleteCustomer(customerId);

        ResponseEntity<Void> responseEntity = controller.removeCustomer(customerId);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
    }

    @Test
    void update_givenValidRequest_then_returnSuccess() {
        long citizenNumber = 1234;
        Customer expected = new Customer();
        expected.setCitizenNumber(1234);

        when(customerService.updateActivation(citizenNumber)).thenReturn(expected);
        ResponseEntity<Customer> customerResponseEntity = controller.updateActivation(citizenNumber);

        assertEquals(expected,customerResponseEntity.getBody());
    }
}
