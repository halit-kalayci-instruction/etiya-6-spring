package com.etiya.ecommercedemo.repositories.abstracts;

import com.etiya.ecommercedemo.entities.concrete.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order,Integer> {
}
