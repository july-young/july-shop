package com.july.shop.member.service.impl;

import com.july.shop.api.dto.member.input.UserInpDTO;
import com.july.shop.api.member.MemberRegisterService;
import com.july.shop.api.member.entity.UserDo;
import com.july.shop.common.base.api.BaseApiService;
import com.july.shop.common.base.entity.BaseResponse;
import com.july.shop.common.constants.Constants;
import com.july.shop.common.utils.JulyBeanUtils;
import com.july.shop.common.utils.MD5Util;
import com.july.shop.member.feign.VerifyCodeServiceFeign;
import com.july.shop.member.mapper.UserMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: july
 * @date: 2020/2/25 19:46
 * @description:
 */
@RestController
public class MemberRegisterServiceImpl extends BaseApiService<JSONObject> implements MemberRegisterService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private VerifyCodeServiceFeign verifyCodeServiceFeign;

    @Override
    @Transactional
    public BaseResponse<JSONObject> register(@RequestBody UserInpDTO userInpDTO, String registCode) {
        // 1.参数验证
        String userName = userInpDTO.getUserName();
        if (StringUtils.isEmpty(userName)) {
            return setResultError("用户名称不能为空!");
        }
        String mobile = userInpDTO.getMobile();
        if (StringUtils.isEmpty(mobile)) {
            return setResultError("手机号码不能为空!");
        }
        String password = userInpDTO.getPassword();
        if (StringUtils.isEmpty(password)) {
            return setResultError("密码不能为空!");
        }
        // // 2.验证码注册码是否正确 暂时省略 会员调用微信接口实现注册码验证
//         BaseResponse<JSONObject> verifyWeixinCode =
//         verifyCodeServiceFeign.verifyWeixinCode(mobile, registCode);
//         if
//         (!verifyWeixinCode.getCode().equals(Constants.HTTP_RES_CODE_200)) {
//         return setResultError(verifyWeixinCode.getMsg());
//         }
        // 3.对用户的密码进行加密 // MD5 可以解密 暴力破解
        String newPassword = MD5Util.MD5(password);
        userInpDTO.setPassword(newPassword);
        // 4.调用数据库插入数据 将请求的dto参数转换DO
        UserDo userDo = JulyBeanUtils.dtoToDo(userInpDTO, UserDo.class);
        return userMapper.register(userDo) > 0 ? setResultSuccess("注册成功") : setResultError("注册失败!");
    }
    // dto 和do 可能 实体类不同，但是部分参数可能相同

}
