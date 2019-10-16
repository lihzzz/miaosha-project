package com.davin.miaoshaproject.controller.viewobject;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemVo {
    private Integer id;
    private String title;
    private BigDecimal price;
    private String description;
    private Integer sales;
    private Integer stock;
    private String imgUrl;
}
