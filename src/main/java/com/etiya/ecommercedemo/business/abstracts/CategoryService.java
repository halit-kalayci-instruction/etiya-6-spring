package com.etiya.ecommercedemo.business.abstracts;

import com.etiya.ecommercedemo.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommercedemo.business.dtos.requests.category.UpdateCategoryRequest;
import com.etiya.ecommercedemo.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercedemo.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemo.business.dtos.responses.category.UpdateCategoryResponse;
import com.etiya.ecommercedemo.core.utils.result.DataResult;
import com.etiya.ecommercedemo.core.utils.result.Result;
import com.etiya.ecommercedemo.entities.concrete.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface CategoryService {
    List<ListCategoryResponse> getAll();
    DataResult<Slice<ListCategoryResponse>> getAllWithPagination(Pageable pageable);
    AddCategoryResponse add(AddCategoryRequest addCategoryRequest) throws Exception;
    Result categoryWithIdShouldExists(int categoryId);
    DataResult<UpdateCategoryResponse> update(UpdateCategoryRequest updateCategoryRequest);
}
