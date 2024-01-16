package com.market.connect.models.dtos;

import com.market.connect.models.ProductCategory;
import com.market.connect.models.entities.Customer;
import com.market.connect.models.entities.Order;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class ProductDTO {

    private Long id;

    private String productName;

    private Map<Customer, String> customerStringMap;

    private Map<Customer, String> customerReviews;

    private Double productPrice;

    private ProductCategory productCategory;

    private String productDescription;
}
