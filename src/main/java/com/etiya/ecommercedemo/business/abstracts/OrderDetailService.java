package com.etiya.ecommercedemo.business.abstracts;

import com.etiya.ecommercedemo.business.dtos.requests.orderDetail.AddOrderDetailRequest;
import com.etiya.ecommercedemo.core.utils.result.Result;

import java.util.List;

public interface OrderDetailService {
    Result addRange(int orderId, List<AddOrderDetailRequest> addOrderDetailRequest);
}
