package com.etiya.ecommercedemo.api.controllers;

import com.etiya.ecommercedemo.business.abstracts.ProductService;
import com.etiya.ecommercedemo.business.dtos.requests.product.AddProductRequest;
import com.etiya.ecommercedemo.business.dtos.responses.product.AddProductResponse;
import com.etiya.ecommercedemo.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommercedemo.business.dtos.responses.product.ProductDetailResponse;
import com.etiya.ecommercedemo.core.utils.result.DataResult;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductsController {
    private ProductService productService;


    @PostMapping("")
    public DataResult<AddProductResponse> add(@Valid @RequestBody AddProductRequest addProductRequest){
        DataResult<AddProductResponse> response = productService.add(addProductRequest);
        return response;
    }

    @GetMapping("")
    public DataResult<List<ListProductResponse>> getAll(){
        return productService.getAll();
    }

    @GetMapping("{id}")
    public DataResult<ProductDetailResponse> getById(@PathVariable int id){
        return productService.getById(id);
    }

}
