package com.etiya.ecommercedemo.business.concretes;

import com.etiya.ecommercedemo.business.abstracts.CategoryService;
import com.etiya.ecommercedemo.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommercedemo.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercedemo.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemo.core.exceptions.BusinessException;
import com.etiya.ecommercedemo.core.utils.mapping.ModelMapperService;
import com.etiya.ecommercedemo.entities.concrete.Category;
import com.etiya.ecommercedemo.repositories.abstracts.CategoryDao;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private CategoryDao categoryDao;
    private ModelMapperService modelMapperService;

    private MessageSource messageSource;


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
            throw new BusinessException(messageSource.getMessage("categoryExists",null, LocaleContextHolder.getLocale()));
        // Category oluşturmam gerekli

        // AddCategoryRequest => Category => AddCategoryResponse
        // Manual Mapping => Auto Mapping => ModelMapper
        //Category category = new Category();
        //category.setName(addCategoryRequest.getName());
        // Auto Mapping
        Category category = modelMapperService.getMapper().map(addCategoryRequest,Category.class);
        categoryDao.save(category);

        // Manual
        //AddCategoryResponse response = new AddCategoryResponse();
        //response.setId(category.getId());
        //response.setName(category.getName());
        // Auto
        AddCategoryResponse response = modelMapperService.getMapper().map(category, AddCategoryResponse.class);
        return response;
    }
}
