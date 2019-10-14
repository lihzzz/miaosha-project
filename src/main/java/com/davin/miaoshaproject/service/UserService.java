package com.davin.miaoshaproject.service;

import com.davin.miaoshaproject.error.BusinessException;
import com.davin.miaoshaproject.service.model.UserModel;

public interface UserService {

    UserModel getUserById(Integer id);

    void register(UserModel userModel) throws BusinessException;
}
