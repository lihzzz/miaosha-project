package com.davin.miaoshaproject.controller.viewobject;

import lombok.Data;

@Data
public class UserVo {
    private Integer id;
    private String  name;
    private Byte  gender;
    private int age;
    private String telphone;
    private String registerMode;
    private String thirdPartyId;
}
