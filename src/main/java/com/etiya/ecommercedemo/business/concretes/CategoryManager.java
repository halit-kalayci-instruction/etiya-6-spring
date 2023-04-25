package com.etiya.ecommercedemo.business.concretes;

import com.etiya.ecommercedemo.business.abstracts.CategoryService;
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
    public List<Category> getAll() {
        // kullanıcı giriş yapmış mı?
        // sayfalama bilgileri doğru girilmiş mi?
        // category ismi 3 haneden büyük olmalıdır?
        // Never Trust User Input
        return categoryDao.findAll();
    }
}
