package com.davin.miaoshaproject.error;

public interface CommonError {

    public int getErrorCode();
    public String getErrMsg();
    public CommonError setErrMsg(String errMsg);
}
