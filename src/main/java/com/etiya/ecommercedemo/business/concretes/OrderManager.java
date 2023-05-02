package com.etiya.ecommercedemo.business.concretes;

import com.etiya.ecommercedemo.business.abstracts.OrderDetailService;
import com.etiya.ecommercedemo.business.abstracts.OrderService;
import com.etiya.ecommercedemo.business.dtos.requests.order.AddOrderRequest;
import com.etiya.ecommercedemo.core.utils.mapping.ModelMapperService;
import com.etiya.ecommercedemo.core.utils.result.Result;
import com.etiya.ecommercedemo.core.utils.result.SuccessResult;
import com.etiya.ecommercedemo.entities.concrete.Order;
import com.etiya.ecommercedemo.repositories.abstracts.OrderDao;
import com.etiya.ecommercedemo.repositories.abstracts.OrderDetailDao;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderManager implements OrderService {
    private final OrderDao orderDao;
    private final OrderDetailService orderDetailService;
    private final MessageSource messageSource;
    private final ModelMapperService modelMapperService;

    @Autowired
    public OrderManager(OrderDao orderDao, OrderDetailService orderDetailService, MessageSource messageSource, ModelMapperService modelMapperService) {
        this.orderDao = orderDao;
        this.orderDetailService = orderDetailService;
        this.messageSource = messageSource;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public Result add(AddOrderRequest addOrderRequest) {
        Order order = new Order();
        order.setDate(new Date());
        orderDao.save(order);
        orderDetailService.addRange(order.getId() , addOrderRequest.getOrderDetails());
        return new SuccessResult();
    }
}
