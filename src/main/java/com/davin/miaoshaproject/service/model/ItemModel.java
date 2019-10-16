package com.davin.miaoshaproject.service.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Data
public class ItemModel {
    private Integer id;


    @NotNull(message = "shang ping bu neng wei kong")
    private String title;

    @NotNull(message = "shang ping jiage bu neng wei kong")
    @Min(value = 0,message = "shang ping jia ge yao da yu 0")
    private BigDecimal price;

    @NotNull(message = "shang ping miao shu bu neng wei kong")
    private String description;

    private Integer sales;

    @NotNull(message = "shang ping tu pian bu neng wei kong")
    private  String imgUrl;

    @NotNull(message = "shang ping ku cun bu neng wei kong")
    private Integer stock;

    private PromoModel promoModel;

}
