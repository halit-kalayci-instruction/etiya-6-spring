package com.etiya.ecommercedemo.repositories.abstracts;

import com.etiya.ecommercedemo.entities.concrete.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDao extends JpaRepository<OrderDetail,Integer> {
}
