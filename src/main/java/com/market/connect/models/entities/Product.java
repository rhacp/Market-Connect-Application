package com.market.connect.models.entities;

import com.market.connect.models.ProductCategory;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Data
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @ElementCollection
    @CollectionTable(name = "customer_ratings", joinColumns = @JoinColumn(name = "customer_id"))
    @MapKeyColumn(name = "customer_email")
    @Column(name = "rating")
    private Map<Customer, String> customerStringMap;

    @ElementCollection
    @CollectionTable(name = "customer_review", joinColumns = @JoinColumn(name = "customer_id"))
    @MapKeyColumn(name = "customer_email")
    @Column(name = "review")
    private Map<Customer, String> customerReviews;

    @Column(name = "product_price")
    private Double productPrice;

    @Column(name = "product_category")
    private ProductCategory productCategory;

    @Column(name = "product_description")
    private String productDescription;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders = new ArrayList<>();
}
