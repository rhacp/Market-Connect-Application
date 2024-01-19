package com.market.connect.models.dtos;

import com.market.connect.utils.ProductCategory;
import com.market.connect.models.entities.Customer;
import lombok.Data;

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
