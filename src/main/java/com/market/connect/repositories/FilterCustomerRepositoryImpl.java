package com.market.connect.repositories;

import com.market.connect.models.entities.Customer;
import com.market.connect.utils.Subscription;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

public class FilterCustomerRepositoryImpl implements FilterCustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findFilteredCustomers(Boolean active, String city, Subscription subscription) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);

        Root<Customer> customerRoot = cq.from(Customer.class);
        List<Predicate> predicates = new ArrayList<>();

        if (active != null) {
            predicates.add(cb.equal(customerRoot.get("active"), active));
        }
        if (city != null) {
            predicates.add(cb.equal(customerRoot.get("city"), city));
        }
        if (subscription != null) {
            predicates.add(cb.equal(customerRoot.get("subscription"), subscription));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(cq).getResultList();
    }
}
