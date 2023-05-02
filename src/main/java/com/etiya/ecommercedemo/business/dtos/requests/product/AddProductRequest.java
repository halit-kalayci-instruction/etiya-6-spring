package com.etiya.ecommercedemo.business.dtos.requests.product;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddProductRequest {
    @NotBlank(message = "nameMustNotBeEmpty")
    @NotNull(message = "Name alanı boş bırakılamaz.")
    @Size(min = 2, message = "Name alanı 2 karakterden kısa olamaz.")
    private String name;
    @Min(1)
    private double unitPrice;
    private int categoryId;
}
// Defensive Programming
// Never Trust User Input