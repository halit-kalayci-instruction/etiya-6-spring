package com.etiya.ecommercedemo.business.abstracts;

import com.etiya.ecommercedemo.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommercedemo.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercedemo.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemo.entities.concrete.Category;

import java.util.List;

public interface CategoryService {
    List<ListCategoryResponse> getAll();
    AddCategoryResponse add(AddCategoryRequest addCategoryRequest) throws Exception;
}
