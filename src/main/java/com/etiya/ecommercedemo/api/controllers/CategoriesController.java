package com.etiya.ecommercedemo.api.controllers;

import com.etiya.ecommercedemo.business.abstracts.CategoryService;
import com.etiya.ecommercedemo.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommercedemo.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercedemo.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemo.entities.concrete.Category;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoriesController {
    private CategoryService categoryService;


    @GetMapping("")
    public List<ListCategoryResponse> getAll(){
        // Business katmanı
        return categoryService.getAll();
    }

    @PostMapping("")
    public AddCategoryResponse add(@RequestBody AddCategoryRequest addCategoryRequest) throws Exception {
       return categoryService.add(addCategoryRequest);
    }
}
