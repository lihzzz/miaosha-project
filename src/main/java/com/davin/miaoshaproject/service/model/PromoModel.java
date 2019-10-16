package com.davin.miaoshaproject.service.model;

import lombok.Data;
import org.joda.time.DateTime;

import java.math.BigDecimal;

@Data
public class PromoModel {

    private Integer id;
    private Integer status;
    private String promo_name;
    private DateTime startDate;
    private DateTime endDate;
    private Integer itemId;
    private BigDecimal promo_item_pric;
}
