package com.davin.miaoshaproject.controller;

import com.alibaba.druid.util.StringUtils;
import com.davin.miaoshaproject.controller.viewobject.UserVo;
import com.davin.miaoshaproject.error.BusinessError;
import com.davin.miaoshaproject.error.BusinessException;
import com.davin.miaoshaproject.response.CommonReturnType;
import com.davin.miaoshaproject.service.UserService;
import com.davin.miaoshaproject.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {"*"}, allowCredentials = "true")

public class UserController extends BaseController{


    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest httpServletRequest;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public CommonReturnType login(@RequestParam(name = "telphone") String telphone,
                                  @RequestParam(name = "password") String password) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        if(org.apache.commons.lang3.StringUtils.isEmpty(telphone) || org.apache.commons.lang3.StringUtils.isEmpty(password)){
            throw new BusinessException(BusinessError.PARAMETER_VALIDATION_ERROR);
        }

        UserModel userModel = userService.validateLogin(telphone,this.enCodeByMD5(password));

        if(userModel != null){
            UserVo userVo = convertFromMode(userModel);
            httpServletRequest.getSession().setAttribute("IS_LOGIN",true);
            httpServletRequest.getSession().setAttribute("LOGIN_USER",userModel);
            return CommonReturnType.create(userVo);
        }else{
            return CommonReturnType.create(null);
        }



    }

    private UserVo convertFromMode(UserModel userModel){
        if(userModel == null){
            return null;
        }
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userModel,userVo);
        return userVo;
    }


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public CommonReturnType register(@RequestParam(name = "telphone") String telphone,
                                     @RequestParam(name = "otpCode") String otpCode,
                                     @RequestParam(name = "name") String name,
                                     @RequestParam(name = "gender") Integer gender,
                                     @RequestParam(name = "age") Integer age,
                                     @RequestParam(name="password")String password) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        String inSessionOtpCode = (String) this.httpServletRequest.getSession().getAttribute(telphone);
        System.out.println(inSessionOtpCode);
        if(!StringUtils.equals(otpCode,inSessionOtpCode)){
            throw new BusinessException(BusinessError.PARAMETER_VALIDATION_ERROR,"验证码错误");

        }


        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setGender(new Byte(String.valueOf(gender.intValue())));
        userModel.setAge(age);
        userModel.setTelphone(telphone);
        userModel.setRegisterMode("byphone");
        userModel.setEncrptPassword(this.enCodeByMD5(password));

        System.out.println(userModel.toString());

        userService.register(userModel);
        return CommonReturnType.create(null);
    }

    public String enCodeByMD5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");

        BASE64Encoder base64Encoder = new BASE64Encoder();

        String newStr = base64Encoder.encode(md5.digest(str.getBytes("utf-8")));
        return newStr;
    }

    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name = "id")Integer id ) throws BusinessException {
        UserModel userModel = userService.getUserById(id);
        if(userModel == null){
            //userModel.setEncrptPassword("asas");
            throw new BusinessException(BusinessError.USER_NOT_EXIST);
        }
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userModel,userVo);
        return CommonReturnType.create(userVo);
    }


    @RequestMapping(value = "/getotp",method = RequestMethod.POST)
    @ResponseBody
    public CommonReturnType getOtp(@RequestParam(name = "telphone") String telphone){
        Random random = new Random();
        int randomInt =  random.nextInt(99999);
        randomInt += 10000;

        String otpCode = String.valueOf(randomInt);

        //将OTP验证同对应用户的手机号关联，使用HTTP session的方式绑定(redis非常适用）
        httpServletRequest.getSession().setAttribute(telphone,otpCode);
        String res = "telphone = " + telphone + "&optCode=" + otpCode;
        //将OTP验证码通过短信通道发送给用户，省略
        System.out.println(res);

        return CommonReturnType.create(res);
    }




}
