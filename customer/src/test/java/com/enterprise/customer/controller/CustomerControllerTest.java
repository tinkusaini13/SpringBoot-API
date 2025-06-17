package com.enterprise.customer.controller;

import com.enterprise.customer.CustomerApplication;
import com.enterprise.customer.entity.Customer;
import com.enterprise.customer.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = CustomerApplication.class)
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Customer savedCustomer;

    @BeforeEach
    void setup() {
        customerRepository.deleteAll(); // Clean up DB before each test

        Customer customer = new Customer();
        customer.setFirstName("Vikas");
        customer.setMiddleName("K");
        customer.setLastName("Sharma");
        customer.setEmail("vikas.sharma@example.com");
        customer.setPhone("9876543210");

        savedCustomer = customerRepository.save(customer);
    }

    @Test
    void testCreateCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setFirstName("Amit");
        customer.setLastName("Kumar");
        customer.setEmail("amit.kumar@example.com");
        customer.setPhone("9876543211");

        mockMvc.perform(post("/api/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customer)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value("Amit"));
    }

    @Test
    void testGetCustomerById() throws Exception {
        mockMvc.perform(get("/api/customers/" + savedCustomer.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("vikas.sharma@example.com"));
    }

    @Test
    void testGetAllCustomers() throws Exception {
        mockMvc.perform(get("/api/customers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1));
    }

    @Test
    void testUpdateCustomer() throws Exception {
        savedCustomer.setFirstName("Vikash");

        mockMvc.perform(put("/api/customers/" + savedCustomer.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(savedCustomer)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Vikash"));
    }

    @Test
    void testDeleteCustomer() throws Exception {
        mockMvc.perform(delete("/api/customers/" + savedCustomer.getId()))
                .andExpect(status().isNoContent());
    }
}
