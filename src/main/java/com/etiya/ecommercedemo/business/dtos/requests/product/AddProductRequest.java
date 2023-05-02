package com.etiya.ecommercedemo.business.dtos.requests.product;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddProductRequest {
    @NotBlank(message = "{nameMustNotBeEmpty}")
    @NotNull(message = "{nameMustNotBeEmpty}")
    @Size(min = 5, max=30, message = "{nameMustBeBetween}")
    private String name;
    @Min(1)
    private double unitPrice;
    private int categoryId;
}
// Defensive Programming
// Never Trust User Input