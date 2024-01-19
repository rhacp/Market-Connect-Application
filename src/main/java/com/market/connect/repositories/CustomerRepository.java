package com.market.connect.repositories;

import com.market.connect.models.entities.Customer;
import com.market.connect.utils.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, FilterCustomerRepository {

    Customer findByEmail(String email);

    List<Customer> findCustomerByActiveAndCityAndSubscription(Boolean active, String city, Subscription subscription);
}