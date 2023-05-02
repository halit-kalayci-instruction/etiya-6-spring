package com.etiya.ecommercedemo.api.controllers;

import com.etiya.ecommercedemo.business.abstracts.CategoryService;
import com.etiya.ecommercedemo.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommercedemo.business.dtos.requests.category.UpdateCategoryRequest;
import com.etiya.ecommercedemo.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercedemo.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemo.business.dtos.responses.category.UpdateCategoryResponse;
import com.etiya.ecommercedemo.core.utils.result.DataResult;
import com.etiya.ecommercedemo.entities.concrete.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
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

    @GetMapping("getWithPagination")
    public DataResult<Slice<ListCategoryResponse>> getAll(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return categoryService.getAllWithPagination(pageable);
    }

    @PostMapping("")
    public AddCategoryResponse add(@RequestBody AddCategoryRequest addCategoryRequest) throws Exception {
       return categoryService.add(addCategoryRequest);
    }

    @PutMapping("")
    public DataResult<UpdateCategoryResponse> update(@RequestBody UpdateCategoryRequest updateCategoryRequest){
        return categoryService.update(updateCategoryRequest);
    }
}
