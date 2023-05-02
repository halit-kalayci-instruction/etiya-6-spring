package com.etiya.ecommercedemo.business.dtos.requests.order;

import com.etiya.ecommercedemo.business.dtos.requests.orderDetail.AddOrderDetailRequest;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderRequest {
    // productId quantity
    private List<AddOrderDetailRequest> orderDetails;
}
