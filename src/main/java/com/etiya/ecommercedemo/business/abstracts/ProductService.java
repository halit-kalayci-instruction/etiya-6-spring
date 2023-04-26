package com.etiya.ecommercedemo.business.abstracts;

import com.etiya.ecommercedemo.business.dtos.requests.product.AddProductRequest;
import com.etiya.ecommercedemo.business.dtos.responses.product.AddProductResponse;
import com.etiya.ecommercedemo.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommercedemo.business.dtos.responses.product.ProductDetailResponse;

import java.util.List;

public interface ProductService {
    AddProductResponse add(AddProductRequest addProductRequest);

    List<ListProductResponse> getAll();

    ProductDetailResponse getById(int id);
}
