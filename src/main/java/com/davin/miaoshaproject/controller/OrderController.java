package com.davin.miaoshaproject.controller;

import com.davin.miaoshaproject.error.BusinessError;
import com.davin.miaoshaproject.error.BusinessException;
import com.davin.miaoshaproject.response.CommonReturnType;
import com.davin.miaoshaproject.service.OrderService;
import com.davin.miaoshaproject.service.model.OrderModel;
import com.davin.miaoshaproject.service.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = {"*"}, allowCredentials = "true")

public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping(value = "/createorder",method = RequestMethod.POST)
    @ResponseBody
    public CommonReturnType createOrder(@RequestParam(name = "itemId") Integer itemId,
                                        @RequestParam(name = "promoId",required = false)Integer promId,
                                        @RequestParam(name = "amount")Integer amount) throws BusinessException{
        Boolean isLogin = (Boolean) this.httpServletRequest.getSession().getAttribute("IS_LOGIN");
        System.out.println(isLogin.booleanValue());

        if(isLogin == null || !isLogin.booleanValue()){
            throw new BusinessException(BusinessError.USER_NOT_LOGIN,"yong hu hai wei deng lu");
        }

        UserModel userModel = (UserModel) this.httpServletRequest.getSession().getAttribute("LOGIN_USER");
        OrderModel orderModel = orderService.createOrder(userModel.getId(),itemId,promId,amount);
        return CommonReturnType.create(null);
    }


}
