package com.etiya.ecommercedemo.business.abstracts;

import com.etiya.ecommercedemo.business.dtos.requests.order.AddOrderRequest;
import com.etiya.ecommercedemo.core.utils.result.Result;

public interface OrderService {
    Result add(AddOrderRequest addOrderRequest);
}
