package com.etiya.ecommercedemo.business.concretes;

import com.etiya.ecommercedemo.business.dtos.requests.category.UpdateCategoryRequest;
import com.etiya.ecommercedemo.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemo.business.dtos.responses.category.UpdateCategoryResponse;
import com.etiya.ecommercedemo.core.exceptions.types.BusinessException;
import com.etiya.ecommercedemo.core.exceptions.types.NotFoundException;
import com.etiya.ecommercedemo.core.utils.mapping.ModelMapperManager;
import com.etiya.ecommercedemo.core.utils.mapping.ModelMapperService;
import com.etiya.ecommercedemo.core.utils.result.DataResult;
import com.etiya.ecommercedemo.core.utils.result.SuccessDataResult;
import com.etiya.ecommercedemo.entities.concrete.Category;
import com.etiya.ecommercedemo.repositories.abstracts.CategoryDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CategoryManagerTest {

    // Business Classlar test ederiz.
    // bağımlılık yükleme
    CategoryDao categoryDao;
    ModelMapperService modelMapperService;
    MessageSource messageSource;

    CategoryManager categoryManager;
    // Mockito
    @BeforeEach
    void setUp() {
        // Her test öncesi çalıştırılacak alan.

        modelMapperService = new ModelMapperManager(new ModelMapper());
        messageSource = getBundleMessageSource();
        categoryDao = mock(CategoryDao.class);
        categoryManager = new CategoryManager(categoryDao, modelMapperService, messageSource);
    }

    ResourceBundleMessageSource getBundleMessageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }


    @AfterEach
    void tearDown() {
        // Her test sonrası çalıştırılacak alan.
    }

    @Test
    void add() {
        // 3A Principle
        // 3A prensipi

        // Arrange, Act, Assert

        // Arrange => Testimi yapacağım ortamın hazırlanması.  Örn. Mock objelerin oluşturulması. Bağımlılıkların yüklenmesi.

        // Act (Action) => CategoryManager.Add(); (Test edeceğim metodu işleme almak.)

        // Assert (Beklenti) => Expected durum ile Actual durum karşılaştırmasının yapıldığı nokta.
        // categoryManager.add().throwsException() ? boolean
    }

    @Test
    void getAll(){
        // mock
        List<ListCategoryResponse> expectedData = new ArrayList<>();
        expectedData.add(new ListCategoryResponse(1,"Giyim"));
        expectedData.add(new ListCategoryResponse(2, "Deneme"));
        when(categoryDao.getAll()).thenReturn(expectedData);


        List<ListCategoryResponse> actualResult = categoryManager.getAll();

        assert expectedData.size() == actualResult.size();
    }

    @Test
    void updateWithNonExistingIdShouldThrowException(){
        // findById
        // Mocklamada parametreler
        // herhangi bir parametre
        when(categoryDao.findById(any())).thenReturn(Optional.ofNullable(null));
        UpdateCategoryRequest request = new UpdateCategoryRequest(2,"Giyim");
        assertThrows(NotFoundException.class,()->{
            categoryManager.update(request);
        });
    }

    @Test
    void updateWithSameNameShouldThrowException(){
        when(categoryDao.findById(any())).thenReturn(Optional.of(new Category()));
        when(categoryDao.findByName(any())).thenReturn(new Category());
        UpdateCategoryRequest request = new UpdateCategoryRequest(2,"Deneme");
        assertThrows(BusinessException.class, () -> { categoryManager.update(request); });
    }

    @Test
    void update(){
        when(categoryDao.findById(any())).thenReturn(Optional.of(new Category()));
        when(categoryDao.findByName(any())).thenReturn(null);

        UpdateCategoryRequest request = new UpdateCategoryRequest(2,"Deneme");

        DataResult<UpdateCategoryResponse> actualResponse = categoryManager.update(request);
        SuccessDataResult<UpdateCategoryResponse> expectedResponse =
                new SuccessDataResult<>(new UpdateCategoryResponse(2,"Deneme"));
        assert actualResponse.equals(expectedResponse);
    }
}