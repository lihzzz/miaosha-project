package com.davin.miaoshaproject.service.impl;

import com.davin.miaoshaproject.controller.viewobject.UserVo;
import com.davin.miaoshaproject.dao.UserInfoMapper;
import com.davin.miaoshaproject.dao.UserPasswordMapper;
import com.davin.miaoshaproject.error.BusinessError;
import com.davin.miaoshaproject.error.BusinessException;
import com.davin.miaoshaproject.model.UserInfo;
import com.davin.miaoshaproject.model.UserPassword;
import com.davin.miaoshaproject.service.UserService;
import com.davin.miaoshaproject.service.model.UserModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        UserPassword userPassword = userPasswordMapper.selectByPrimaryKey(userInfo.getId());
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
    private UserInfo convertFromModel(UserModel userModel){
        if(userModel == null){
            return null;
        }
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userModel,userInfo);
        return userInfo;
    }

    private UserPassword convertPasswordFromModen(UserModel userModel){
        if(userModel == null){
            return null;
        }
        UserPassword userPassword = new UserPassword();
        BeanUtils.copyProperties(userModel,userPassword);
        return userPassword;
    }


    @Transactional
    @Override
    public void register(UserModel userModel) throws BusinessException{
        if(userModel == null){
            throw new BusinessException(BusinessError.PARAMETER_VALIDATION_ERROR);
        }

        if(StringUtils.isEmpty(userModel.getName()) || userModel.getGender() == null
                 || StringUtils.isEmpty(userModel.getTelphone())){
            throw new BusinessException(BusinessError.PARAMETER_VALIDATION_ERROR);
        }


        UserInfo userInfo = convertFromModel(userModel);
        userInfoMapper.insertSelective(userInfo);

        UserPassword userPassword = convertPasswordFromModen(userModel);
        userPasswordMapper.insertSelective(userPassword);


        return;

    }
}
