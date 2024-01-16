package com.market.connect.models.dtos;

import com.market.connect.models.entities.Customer;
import com.market.connect.models.entities.Product;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDTO {

    private Long id;

    private LocalDateTime createdAt;

    private Customer customer;

    private List<Product> products;
}
