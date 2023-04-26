package com.etiya.ecommercedemo.business.dtos.responses.product;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProductDetailResponse {
    private int id;
    private String name;
    private int categoryId;
    private String category;
}
