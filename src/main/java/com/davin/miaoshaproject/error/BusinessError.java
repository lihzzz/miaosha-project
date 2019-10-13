package com.davin.miaoshaproject.error;

public enum  BusinessError implements CommonError{

    PARAMETER_VALIDATION_ERROR(10003,"canshubuhefa"),
    UNKONE_ERROR(10004,"未知错误"),
    USER_NOT_EXIST(10001,"yonghubucunzai")
        ;

    private BusinessError(int errorCode,String errMsg){
        this.errMsg = errMsg;
        this.errorCode = errorCode;
    }

    private int errorCode;
    private String errMsg;


    @Override
    public int getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
