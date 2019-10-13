package com.davin.miaoshaproject.controller;

import com.davin.miaoshaproject.controller.viewobject.UserVo;
import com.davin.miaoshaproject.dao.UserInfoMapper;
import com.davin.miaoshaproject.error.BusinessError;
import com.davin.miaoshaproject.error.BusinessException;
import com.davin.miaoshaproject.model.UserInfo;
import com.davin.miaoshaproject.response.CommonReturnType;
import com.davin.miaoshaproject.service.UserService;
import com.davin.miaoshaproject.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController{


    @Autowired
    private UserService userService;

    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name = "id")Integer id ) throws BusinessException {
        UserModel userModel = userService.getUserById(id);
        if(userModel == null){
            userModel.setEncrptPassword("asas");
            //throw new BusinessException(BusinessError.USER_NOT_EXIST);
        }
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userModel,userVo);
        return CommonReturnType.create(userVo);
    }




}
