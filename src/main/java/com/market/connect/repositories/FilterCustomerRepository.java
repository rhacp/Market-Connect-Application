package com.market.connect.repositories;

import com.market.connect.models.entities.Customer;
import com.market.connect.utils.Subscription;

import java.util.List;

public interface FilterCustomerRepository {

    List<Customer> findFilteredCustomers(Boolean active, String city, Subscription subscription);
}
