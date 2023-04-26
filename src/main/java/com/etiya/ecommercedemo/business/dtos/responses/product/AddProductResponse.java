package com.etiya.ecommercedemo.business.dtos.responses.product;

import com.etiya.ecommercedemo.entities.concrete.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddProductResponse {
    private int id;
    private String name;
    private double unitPrice;
    private Category category;
}
