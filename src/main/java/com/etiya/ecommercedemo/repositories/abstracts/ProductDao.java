package com.etiya.ecommercedemo.repositories.abstracts;

import com.etiya.ecommercedemo.entities.concrete.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {
}
