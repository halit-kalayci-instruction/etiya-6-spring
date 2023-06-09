package com.etiya.ecommercedemo.business.concretes;

import com.etiya.ecommercedemo.business.abstracts.CategoryService;
import com.etiya.ecommercedemo.business.constants.Messages;
import com.etiya.ecommercedemo.business.dtos.requests.category.AddCategoryRequest;
import com.etiya.ecommercedemo.business.dtos.requests.category.UpdateCategoryRequest;
import com.etiya.ecommercedemo.business.dtos.responses.category.AddCategoryResponse;
import com.etiya.ecommercedemo.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemo.business.dtos.responses.category.UpdateCategoryResponse;
import com.etiya.ecommercedemo.core.exceptions.types.BusinessException;
import com.etiya.ecommercedemo.core.exceptions.types.NotFoundException;
import com.etiya.ecommercedemo.core.internationalization.MessageService;
import com.etiya.ecommercedemo.core.utils.mapping.ModelMapperService;
import com.etiya.ecommercedemo.core.utils.result.*;
import com.etiya.ecommercedemo.entities.concrete.Category;
import com.etiya.ecommercedemo.repositories.abstracts.CategoryDao;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private CategoryDao categoryDao;
    private ModelMapperService modelMapperService;
    private MessageService messageService;


    @Override
    public List<ListCategoryResponse> getAll() {
        // kullanıcı giriş yapmış mı?
        // sayfalama bilgileri doğru girilmiş mi?
        // category ismi 3 haneden büyük olmalıdır?
        // Never Trust User Input
        return categoryDao.getAll();
        //return new ArrayList<>();
    }

    @Override
    public DataResult<Slice<ListCategoryResponse>> getAllWithPagination(Pageable pageable) {
        return new SuccessDataResult<>(categoryDao.getAll(pageable));
    }

    @Override
    public AddCategoryResponse add(AddCategoryRequest addCategoryRequest) throws Exception {
        // validation, business rules
        checkIfCategoryWithSameNameExists(addCategoryRequest.getName());


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

    @Override
    public Result categoryWithIdShouldExists(int categoryId) {
        boolean isCategoryExists = categoryDao.existsCategoryById(categoryId);
        if(isCategoryExists)
            return new SuccessResult();
        return new ErrorResult();
    }

    @Override
    public DataResult<UpdateCategoryResponse> update(UpdateCategoryRequest updateCategoryRequest) {
        // verilen id ile bir kategori olup olmadığına bakmak
        // bu id'ye sahip kategoriyi getirmek
        // name alanını set etmek
        //checkIfCategoryWithIdExists(updateCategoryRequest.getId());
        Category category = categoryDao.findById(updateCategoryRequest.getId())
                .orElseThrow(() -> new NotFoundException(messageService.getMessageWithParams(Messages.Category.CategoryDoesNotExistsWithGivenId, updateCategoryRequest.getId())));
        checkIfCategoryWithSameNameExists(updateCategoryRequest.getName());

        //TODO: Mapper
        category.setName(updateCategoryRequest.getName());
        categoryDao.save(category);

        UpdateCategoryResponse response = modelMapperService.getMapper().map(category, UpdateCategoryResponse.class);
        return new SuccessDataResult<>(response);
    }

    // iş kuralı
    // İŞ KURALI METODLARI AYRI OLMALI
    // aynı isimde 2 kategori olamaz.

    // Magic String =  xFonksiyonu("Deneme")
    // Constants.java => (Sabitler)

    private void checkIfCategoryWithIdExists(int categoryId){
        if(!categoryWithIdShouldExists(categoryId).isSuccess())
            throw new BusinessException(messageService.getMessage(Messages.Category.CategoryDoesNotExistsWithGivenId));
    }

    private void checkIfCategoryWithSameNameExists(String categoryName){
        Category categoryToFind = categoryDao.findByName(categoryName);
        if(categoryToFind != null)
            throw new BusinessException(messageService.getMessage(Messages.Category.CategoryExists));
    }
}
