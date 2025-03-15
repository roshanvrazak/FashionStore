package com.fashionstore.controller;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fashionstore.entity.Customer;
import com.fashionstore.service.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Test
    public void testGetCustomerById() throws Exception {
        Long customerId = 1L;
        Customer mockCustomer = new Customer();
        mockCustomer.setCustomerId(customerId);
        when(customerService.getCustomerById(customerId)).thenReturn(mockCustomer);

        mockMvc.perform(get("/customers/{id}", customerId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(customerId.intValue())));

        verify(customerService, times(1)).getCustomerById(customerId);
    }

}
