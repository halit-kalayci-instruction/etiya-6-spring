package com.etiya.ecommercedemo.business.dtos.requests.product;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddProductRequest {
    private String name;
    private double unitPrice;
    private int categoryId;
}
