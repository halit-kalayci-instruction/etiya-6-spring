package com.etiya.ecommercedemo.business.dtos.requests.orderDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderDetailRequest {
    private int productId;
    private int quantity;
}
