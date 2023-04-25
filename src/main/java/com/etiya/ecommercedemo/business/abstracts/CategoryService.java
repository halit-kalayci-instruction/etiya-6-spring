package com.etiya.ecommercedemo.business.abstracts;

import com.etiya.ecommercedemo.entities.concrete.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
}
