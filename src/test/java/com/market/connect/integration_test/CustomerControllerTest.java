package com.market.connect.integration_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.market.connect.models.dtos.CustomerDTO;
import com.market.connect.utils.Subscription;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureMockMvc
@Transactional
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createCustomerTestShouldPass() throws Exception {
        CustomerDTO customerDTO = CustomerDTO.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@gmail.com")
                .build();

        mockMvc.perform(post("/api/customers")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerDTO)))
                .andExpect(status().isOk());
    }

    @Test
    void getFilteredCustomersShouldPass() throws Exception {
        CustomerDTO customerDTO1 = CustomerDTO.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@gmail.com")
                .active(true)
                .city("Bucharest")
                .subscription(Subscription.STANDARD)
                .build();

        CustomerDTO customerDTO2 = CustomerDTO.builder()
                .firstName("Mary")
                .lastName("Doe")
                .email("mary@gmail.com")
                .active(true)
                .city("Bucharest")
                .subscription(Subscription.STANDARD)
                .build();

        CustomerDTO customerDTO3 = CustomerDTO.builder()
                .firstName("Bill")
                .lastName("Clinton")
                .email("bill@gmail.com")
                .active(true)
                .city("Cluj")
                .subscription(Subscription.STANDARD)
                .build();

        List<CustomerDTO> customers = List.of(customerDTO1, customerDTO2, customerDTO3);

        for (CustomerDTO customer : customers) {
            mockMvc.perform(post("/api/customers")
                            .contentType(APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(customer)))
                    .andExpect(status().isOk());
        }

        MvcResult result = mockMvc.perform(get("/api/customers/filter?active=true&city=Bucharest&subscription=STANDARD")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String stringResult = result.getResponse().getContentAsString();
        List<CustomerDTO> convertedCustomerDTOs = objectMapper.readerForListOf(CustomerDTO.class).readValue(stringResult);

        assertEquals(convertedCustomerDTOs.size(), 2);
    }
}
