package com.davin.miaoshaproject.service;

import com.davin.miaoshaproject.error.BusinessException;
import com.davin.miaoshaproject.model.OrderInfo;
import com.davin.miaoshaproject.service.model.OrderModel;

public interface OrderService {
    OrderModel createOrder(Integer userId,Integer itemId,Integer promoId,Integer amount) throws BusinessException;

    String generatorOrderNo();
    OrderInfo convertFromOrderModel(OrderModel orderModel);
}
