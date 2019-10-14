package com.davin.miaoshaproject.service.model;

import lombok.Data;

@Data
public class UserModel {




    private Integer id;
    private String  name;
    private Byte  gender;
    private int age;
    private String telphone;
    private String registerMode;
    private String thirdPartyId;

    public String getEncrptPassword() {
        return encrptPassword;
    }

    public void setEncrptPassword(String encrptPassword) {
        this.encrptPassword = encrptPassword;
    }

    private String encrptPassword;
}
