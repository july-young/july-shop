package com.july.shop.weixin.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.july.shop.common.base.api.BaseApiService;
import com.july.shop.common.base.entity.BaseResponse;
import com.july.shop.common.constants.Constants;
import com.july.shop.common.utils.RedisUtil;
import com.july.shop.weixin.service.VerifyCodeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: july
 * @date: 2020/2/25 17:07
 * @description:
 */
@RestController
public class VerifyCodeServiceImpl extends BaseApiService<JSONObject> implements VerifyCodeService {
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public BaseResponse<JSONObject> verifyWeixinCode(String phone, String weixinCode) {
        if (StringUtils.isEmpty(phone)) {
            return setResultError("手机号码不能为空!");
        }
        if (StringUtils.isEmpty(weixinCode)) {
            return setResultError("注册码不能为空!");
        }
        String code = redisUtil.getString(Constants.WEIXINCODE_KEY + phone);
        if (StringUtils.isEmpty(code)) {
            return setResultError("注册码已经过期,请重新发送验证码");
        }
        if (!code.equals(weixinCode)) {
            return setResultError("注册码不正确");
        }

        return setResultSuccess("注册码验证码正确");
    }

}
