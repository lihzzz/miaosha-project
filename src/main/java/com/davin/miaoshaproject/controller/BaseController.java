package com.davin.miaoshaproject.controller;

import com.davin.miaoshaproject.error.BusinessError;
import com.davin.miaoshaproject.error.BusinessException;
import com.davin.miaoshaproject.response.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BaseController {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handleException(HttpServletRequest httpServletRequest, Exception ex){
        Map<String,Object> responseData = new HashMap<>();

        if(ex instanceof BusinessException){
            BusinessException businessException = (BusinessException) ex;
            responseData.put("errCode",businessException.getErrorCode());
            responseData.put("errMsg",businessException.getErrMsg());
            return CommonReturnType.create(responseData);
        }else{
            responseData.put("errCode", BusinessError.UNKONE_ERROR.getErrorCode());
            responseData.put("errMsg",BusinessError.UNKONE_ERROR.getErrMsg());
            return CommonReturnType.create(responseData,"fail");
        }
    }
}
