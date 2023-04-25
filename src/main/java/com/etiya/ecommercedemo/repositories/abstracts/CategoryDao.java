package com.etiya.ecommercedemo.repositories.abstracts;

import com.etiya.ecommercedemo.entities.concrete.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Integer> {
}
