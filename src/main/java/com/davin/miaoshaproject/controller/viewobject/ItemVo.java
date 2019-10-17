package com.davin.miaoshaproject.controller.viewobject;

import lombok.Data;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ItemVo {
    private Integer id;
    private String title;
    private BigDecimal price;
    private String description;
    private Integer sales;
    private Integer stock;
    private String imgUrl;
    private Integer promoStatus;
    private String startDate;
    private String endDate;
    private BigDecimal promoPrice;
}
