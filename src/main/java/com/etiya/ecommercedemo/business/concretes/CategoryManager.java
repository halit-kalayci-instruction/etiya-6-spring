package com.etiya.ecommercedemo.business.concretes;

import com.etiya.ecommercedemo.business.abstracts.CategoryService;
import com.etiya.ecommercedemo.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommercedemo.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercedemo.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemo.core.exceptions.BusinessException;
import com.etiya.ecommercedemo.entities.concrete.Category;
import com.etiya.ecommercedemo.repositories.abstracts.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements CategoryService {
    private CategoryDao categoryDao;

    @Autowired
    public CategoryManager(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<ListCategoryResponse> getAll() {
        // kullanıcı giriş yapmış mı?
        // sayfalama bilgileri doğru girilmiş mi?
        // category ismi 3 haneden büyük olmalıdır?
        // Never Trust User Input
        return categoryDao.getAll();
    }

    @Override
    public AddCategoryResponse add(AddCategoryRequest addCategoryRequest) throws Exception {
        // validation, business rules
        Category categoryToFind = categoryDao.findByName(addCategoryRequest.getName());
        if(categoryToFind != null)
            // new BusinessException();
            throw new BusinessException("Böyle bir kategori zaten mevcut");
        // Category oluşturmam gerekli

        // AddCategoryRequest => Category => AddCategoryResponse
        // Manual Mapping => Auto Mapping => ModelMapper
        Category category = new Category();
        category.setName(addCategoryRequest.getName());
        // Mapping
        categoryDao.save(category);

        AddCategoryResponse response = new AddCategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        return response;
    }
}
