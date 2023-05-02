package com.etiya.ecommercedemo.business.abstracts;

import com.etiya.ecommercedemo.business.dtos.requests.product.AddProductRequest;
import com.etiya.ecommercedemo.business.dtos.responses.product.AddProductResponse;
import com.etiya.ecommercedemo.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommercedemo.business.dtos.responses.product.ProductDetailResponse;
import com.etiya.ecommercedemo.core.utils.result.DataResult;

import java.util.List;

public interface ProductService {
    DataResult<AddProductResponse> add(AddProductRequest addProductRequest);

    DataResult<List<ListProductResponse>> getAll();

    DataResult<ProductDetailResponse> getById(int id);
}
