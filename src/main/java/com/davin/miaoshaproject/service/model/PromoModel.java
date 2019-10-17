package com.davin.miaoshaproject.service.model;

import lombok.Data;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PromoModel {

    private Integer id;
    private Integer status;
    private String promoName;
    private Date startDate;
    private Date endDate;
    private Integer itemId;
    private BigDecimal promoItemPrice;

}
