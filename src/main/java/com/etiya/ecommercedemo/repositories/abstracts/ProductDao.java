package com.etiya.ecommercedemo.repositories.abstracts;

import com.etiya.ecommercedemo.business.dtos.responses.product.ListProductResponse;
import com.etiya.ecommercedemo.business.dtos.responses.product.ProductDetailResponse;
import com.etiya.ecommercedemo.entities.concrete.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
    @Query(value = "Select new " +
            "com.etiya.ecommercedemo.business.dtos.responses.product.ListProductResponse(p.id, p.name, c.name)" +
            " from Product p JOIN p.category c Order By p.name")
    List<ListProductResponse> getAll();

    @Query(value="Select new com.etiya.ecommercedemo.business.dtos.responses.product" +
            ".ProductDetailResponse(p.id, p.name,c.id, c.name)" +
            "from Product p Join p.category c Where p.id=:id ")
    ProductDetailResponse getById(int id);
}
// Defensive Programming
// Unit-Test
// Sayfalama
// JPQL - SQL
// Multi-Language

