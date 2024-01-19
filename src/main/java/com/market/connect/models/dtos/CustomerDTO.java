package com.market.connect.models.dtos;

import com.market.connect.utils.Subscription;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {

    private Long id;

    @NotBlank(message = "Invalid first name.")
    private String firstName;

    @NotBlank(message = "Invalid last name.")
    private String lastName;

    @NotBlank
    @Email
    private String email;

    private boolean active;

    private String city;

    private Subscription subscription;
}
