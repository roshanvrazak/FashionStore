package com.fashionstore.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.fashionstore.entity.Customer;
import com.fashionstore.reporsitory.CustomerRepository;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void testGetCustomerById() {
        // Arrange
        Long customerId = 1L;
        Customer mockCustomer = new Customer();
        mockCustomer.setCustomerId(customerId);
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(mockCustomer));

        // Act
        Customer result = customerService.getCustomerById(customerId);

        // Assert
        assertNotNull(result);
        assertEquals(customerId, result.getCustomerId());
    }

    // Write more test methods for other service functions
}
