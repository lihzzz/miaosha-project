package com.davin.miaoshaproject.service.impl;

import com.davin.miaoshaproject.dao.UserInfoMapper;
import com.davin.miaoshaproject.dao.UserPasswordMapper;
import com.davin.miaoshaproject.model.UserInfo;
import com.davin.miaoshaproject.model.UserPassword;
import com.davin.miaoshaproject.service.UserService;
import com.davin.miaoshaproject.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserPasswordMapper userPasswordMapper;
    @Override
    public UserModel getUserById(Integer id) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        if(userInfo == null){
            return null;
        }
        UserPassword userPassword = userPasswordMapper.selectByUserId(userInfo.getId());
        UserModel userModel = convertFromDataObject(userInfo,userPassword);
        return userModel;

    }

    private UserModel convertFromDataObject(UserInfo userInfo, UserPassword userPassword){
        if(userInfo == null){
            return null;
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userInfo,userModel);

        if(userPassword != null){
            userModel.setEncrptPassword(userPassword.getEncrptPassword());
        }

        return userModel;
    }
}
