package com.example.customermanagementservice;

import com.example.customermanagementservice.controller.CustomerController;
import com.example.customermanagementservice.controller.CustomerRequest;
import com.example.customermanagementservice.model.Customer;
import com.example.customermanagementservice.repository.CustomerRepository;
import com.example.customermanagementservice.service.impl.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CustomerServiceTest {
    @Mock
    private CustomerServiceImpl customerService;

    @InjectMocks
    private CustomerController controller;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    void getAll_when_called_then_returnSuccess() {
        // Arrange
        CustomerRepository mockCustomerRepository = mock(CustomerRepository.class);
        CustomerServiceImpl customerService = new CustomerServiceImpl(mockCustomerRepository);

        Customer expected = new Customer();
        expected.setCitizenNumber(1234);

        when(mockCustomerRepository.findAll()).thenReturn(List.of(expected));

        // Act
        List<Customer> actualCustomers = customerService.getAll();

        // Assert
        assertEquals(1, actualCustomers.size());
        assertEquals(expected, actualCustomers.get(0));
    }

    @Test
    void getByName_when_validNameProvided_then_returnSuccess() {
        // Arrange
        CustomerRepository mockCustomerRepository = mock(CustomerRepository.class);
        CustomerServiceImpl customerService = new CustomerServiceImpl(mockCustomerRepository);

        Customer expected = new Customer();
        expected.setName("kubra");

        when(mockCustomerRepository.findByName("kubra")).thenReturn(List.of(expected));

        // Act
        List<Customer> actualCustomers = customerService.getByName("kubra");

        // Assert
        assertEquals(1, actualCustomers.size());
        assertEquals(expected, actualCustomers.get(0));
    }

    @Test
    void addCustomer_when_validCustomerRequestProvided_then_Success() {
        // Arrange
        CustomerRepository mockCustomerRepository = mock(CustomerRepository.class);
        CustomerServiceImpl customerService = new CustomerServiceImpl(mockCustomerRepository);

        CustomerRequest customerRequestDTO = new CustomerRequest();
        customerRequestDTO.setName("kubra");
        customerRequestDTO.setSurname("ucar");
        customerRequestDTO.setCitizenNumber(1234);
      //  customerRequestDTO.setBirthDate(2002, 01, 08);
        customerRequestDTO.setActive(true);

        Customer expectedCustomer = new Customer();
        expectedCustomer.setName("kubra");
        expectedCustomer.setSurname("ucar");
        expectedCustomer.setCitizenNumber(1234);
        //expectedCustomer.setBirthDate(2002, 01, 08);
        expectedCustomer.setActive(true);

        when(mockCustomerRepository.save(any(Customer.class))).thenReturn(expectedCustomer);

        // Act
        Customer actualCustomer = customerService.addCustomer(customerRequestDTO);

        // Assert
        assertNotNull(actualCustomer);
        assertEquals(expectedCustomer, actualCustomer);
        verify(mockCustomerRepository, times(1)).save(any(Customer.class));
    }

    @Test
    void deleteCustomer_when_validCustomerIdProvided_then_Success() {
        // Arrange
        CustomerRepository mockCustomerRepository = mock(CustomerRepository.class);
        CustomerServiceImpl customerService = new CustomerServiceImpl(mockCustomerRepository);

        UUID customerId = UUID.randomUUID();

        // Act
        customerService.deleteCustomer(customerId);

        // Assert
        verify(mockCustomerRepository, times(1)).deleteById(customerId);
    }

    @Test
    void updateActivation_when_validCitizenNumberProvided_then_Success() {
        // Arrange
        CustomerRepository mockCustomerRepository = mock(CustomerRepository.class);
        CustomerServiceImpl customerService = new CustomerServiceImpl(mockCustomerRepository);

        long citizenNumber = 1234;

        Customer customer = new Customer();
        customer.setCitizenNumber(citizenNumber);
        customer.setActive(true);

        when(mockCustomerRepository.findByCitizenNumber(citizenNumber)).thenReturn(List.of(customer));
        when(mockCustomerRepository.save(any(Customer.class))).thenReturn(customer);

        // Act
        Customer updatedCustomer = customerService.updateActivation(citizenNumber);

        // Assert
        assertNotNull(updatedCustomer);
        assertEquals(citizenNumber, updatedCustomer.getCitizenNumber());
        assertFalse(updatedCustomer.isActive()); // Aktivasyon durumu tersine döndü mü kontrol et
        verify(mockCustomerRepository, times(1)).save(customer);
    }
}
