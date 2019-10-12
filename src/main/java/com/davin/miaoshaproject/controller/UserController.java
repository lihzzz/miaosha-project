package com.davin.miaoshaproject.controller;

import com.davin.miaoshaproject.controller.viewobject.UserVo;
import com.davin.miaoshaproject.dao.UserInfoMapper;
import com.davin.miaoshaproject.model.UserInfo;
import com.davin.miaoshaproject.service.UserService;
import com.davin.miaoshaproject.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    @ResponseBody
    public UserVo getUser(@RequestParam(name = "id")Integer id ){
        UserModel userModel = userService.getUserById(id);
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userModel,userVo);
        return userVo;
    }

}
