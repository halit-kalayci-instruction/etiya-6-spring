package com.etiya.ecommercedemo.api.controllers;

import com.etiya.ecommercedemo.business.abstracts.OrderService;
import com.etiya.ecommercedemo.business.dtos.requests.order.AddOrderRequest;
import com.etiya.ecommercedemo.core.utils.result.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrdersController {
    private OrderService orderService;


    @PostMapping("")
    public Result addOrder(@RequestBody  AddOrderRequest request){
        return orderService.add(request);
    }

}
