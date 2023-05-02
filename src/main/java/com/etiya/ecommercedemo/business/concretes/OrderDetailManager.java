package com.etiya.ecommercedemo.business.concretes;

import com.etiya.ecommercedemo.business.abstracts.OrderDetailService;
import com.etiya.ecommercedemo.business.dtos.requests.order.AddOrderRequest;
import com.etiya.ecommercedemo.business.dtos.requests.orderDetail.AddOrderDetailRequest;
import com.etiya.ecommercedemo.core.utils.mapping.ModelMapperService;
import com.etiya.ecommercedemo.core.utils.result.Result;
import com.etiya.ecommercedemo.core.utils.result.SuccessResult;
import com.etiya.ecommercedemo.entities.concrete.Order;
import com.etiya.ecommercedemo.entities.concrete.OrderDetail;
import com.etiya.ecommercedemo.repositories.abstracts.OrderDetailDao;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderDetailManager implements OrderDetailService {
    private OrderDetailDao orderDetailDao;
    private ModelMapperService modelMapperService;
    private MessageSource messageSource;


    @Override
    public Result addRange(int orderId, List<AddOrderDetailRequest> addOrderDetailRequest) {
        // Business Rules
        for (AddOrderDetailRequest request: addOrderDetailRequest) {
            OrderDetail detail = modelMapperService.getMapper().map(request, OrderDetail.class);
            Order order = new Order();
            order.setId(orderId);
            detail.setOrder(order);
            orderDetailDao.save(detail);
        }
        return new SuccessResult();
    }
}
