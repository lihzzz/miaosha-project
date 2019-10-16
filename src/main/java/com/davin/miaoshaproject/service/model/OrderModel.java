package com.davin.miaoshaproject.service.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderModel {

    private String id;

    private Integer user_id;

    private Integer item_id;

    private BigDecimal item_price;

    private Integer amount;

    private BigDecimal order_price;

    private Integer promp_id;
}
