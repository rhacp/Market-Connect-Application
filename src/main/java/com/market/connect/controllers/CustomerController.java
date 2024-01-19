package com.market.connect.controllers;

import com.market.connect.models.dtos.CustomerDTO;
import com.market.connect.services.CustomerService;
import com.market.connect.utils.Subscription;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //create customer api (post)
    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.createCustomer(customerDTO));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<CustomerDTO>> getFilteredTasks(@RequestParam(required = false) Boolean active, @RequestParam(required = false) String city, @RequestParam(required = false) Subscription subscription) {
        return ResponseEntity.ok(customerService.getFilteredCustomers(active, city, subscription));
    }
}
