package com.market.connect.services;

import com.market.connect.models.dtos.CustomerDTO;
import com.market.connect.utils.Subscription;

import java.util.List;

public interface CustomerService {

    CustomerDTO createCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> getFilteredCustomers(Boolean active, String city, Subscription subscription);
}
