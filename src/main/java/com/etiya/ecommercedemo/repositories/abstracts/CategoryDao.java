package com.etiya.ecommercedemo.repositories.abstracts;

import com.etiya.ecommercedemo.business.dtos.responses.category.ListCategoryResponse;
import com.etiya.ecommercedemo.entities.concrete.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category, Integer> {
    Category findByName(String name);
    boolean existsCategoryById(int id);
    // JPQL Jpa Query Language => Model ismi kullanır
    // SQL => tablo ismi kullanır
    @Query(value = "Select new " +
            "com.etiya.ecommercedemo.business.dtos.responses.category.ListCategoryResponse(c.id, c.name) " +
            "From Category c",
            nativeQuery = false)
    List<ListCategoryResponse> getAll();

}
