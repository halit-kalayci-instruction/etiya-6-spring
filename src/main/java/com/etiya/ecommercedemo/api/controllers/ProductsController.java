package com.etiya.ecommercedemo.api.controllers;

import com.etiya.ecommercedemo.business.abstracts.ProductService;
import com.etiya.ecommercedemo.business.dtos.requests.product.AddProductRequest;
import com.etiya.ecommercedemo.business.dtos.responses.product.AddProductResponse;
import com.etiya.ecommercedemo.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommercedemo.business.dtos.responses.product.ProductDetailResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductsController {
    private ProductService productService;


    @PostMapping("")
    public AddProductResponse add(AddProductRequest addProductRequest){
        return productService.add(addProductRequest);
    }

    @GetMapping("")
    public List<ListProductResponse> getAll(){
        return productService.getAll();
    }

    @GetMapping("{id}")
    public ProductDetailResponse getById(@PathVariable int id){
        return productService.getById(id);
    }
}
