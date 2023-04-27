package com.etiya.ecommercedemo.business.concretes;

import com.etiya.ecommercedemo.business.abstracts.ProductService;
import com.etiya.ecommercedemo.business.dtos.requests.product.AddProductRequest;
import com.etiya.ecommercedemo.business.dtos.responses.product.AddProductResponse;
import com.etiya.ecommercedemo.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommercedemo.business.dtos.responses.product.ProductDetailResponse;
import com.etiya.ecommercedemo.core.utils.mapping.ModelMapperService;
import com.etiya.ecommercedemo.entities.concrete.Category;
import com.etiya.ecommercedemo.entities.concrete.Product;
import com.etiya.ecommercedemo.repositories.abstracts.ProductDao;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private ProductDao productDao;
    private ModelMapperService modelMapperService;

    @Override
    public AddProductResponse add(AddProductRequest addProductRequest) {
        // Product nesnesi üretmemiz ve maplememiz
        //Product product = new Product();
        //product.setName(addProductRequest.getName());
        //product.setUnitPrice(addProductRequest.getUnitPrice());
        //Category category = new Category();
        //category.setId(addProductRequest.getCategoryId());
        //product.setCategory(category);

        Product product = modelMapperService.getMapper().map(addProductRequest, Product.class);
        productDao.save(product);
        // sol taraf => maplemeyi yaparken esas alacağım değerlerin olduğu instance
        // AddProductResponse => oluşturmak istediğim class
        // Product => oluştururken değerleri okuyacağım instance
        // new AddProductResponse();
        AddProductResponse response = modelMapperService.getMapper().map(product, AddProductResponse.class);
        return response;
    }

    @Override
    public List<ListProductResponse> getAll() {
        return productDao.getAll();
    }

    @Override
    public ProductDetailResponse getById(int id) {
        return productDao.getById(id);
    }
}
