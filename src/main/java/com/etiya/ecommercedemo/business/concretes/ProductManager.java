package com.etiya.ecommercedemo.business.concretes;

import com.etiya.ecommercedemo.business.abstracts.CategoryService;
import com.etiya.ecommercedemo.business.abstracts.ProductService;
import com.etiya.ecommercedemo.business.constants.Messages;
import com.etiya.ecommercedemo.business.dtos.requests.product.AddProductRequest;
import com.etiya.ecommercedemo.business.dtos.responses.product.AddProductResponse;
import com.etiya.ecommercedemo.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommercedemo.business.dtos.responses.product.ProductDetailResponse;
import com.etiya.ecommercedemo.core.exceptions.types.BusinessException;
import com.etiya.ecommercedemo.core.utils.mapping.ModelMapperService;
import com.etiya.ecommercedemo.core.utils.result.DataResult;
import com.etiya.ecommercedemo.core.utils.result.Result;
import com.etiya.ecommercedemo.core.utils.result.SuccessDataResult;
import com.etiya.ecommercedemo.entities.concrete.Product;
import com.etiya.ecommercedemo.repositories.abstracts.ProductDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private final ProductDao productDao;
    private final CategoryService categoryService;
    private final ModelMapperService modelMapperService;

    @Override
    public DataResult<AddProductResponse> add(AddProductRequest addProductRequest) {
        Product product = modelMapperService.getMapper().map(addProductRequest, Product.class);
        // Verilen categoryId ile bir kategori verisi bulunmalıdır.
        // CategoryDao
        // Her bir manager kendi entitysi dışında diğer entitylerin DAO'lerini implemente edemez!
        categoryWithIdShouldExists(addProductRequest.getCategoryId());
        productDao.save(product);
        AddProductResponse response = modelMapperService.getMapper().map(product, AddProductResponse.class);
        return new SuccessDataResult<>(response, Messages.Product.ProductAdded);
    }

    private void categoryWithIdShouldExists(int categoryId){
        Result categoryExists = categoryService.categoryWithIdShouldExists(categoryId);
        if(!categoryExists.isSuccess()){
            throw new BusinessException(Messages.Category.CategoryDoesNotExistsWithGivenId);
        }
    }

    @Override
    public DataResult<List<ListProductResponse>> getAll() {
        return new SuccessDataResult<>(productDao.getAll());
    }

    @Override
    public DataResult<ProductDetailResponse> getById(int id) {
        return new SuccessDataResult<ProductDetailResponse>(productDao.getById(id));
    }
}
