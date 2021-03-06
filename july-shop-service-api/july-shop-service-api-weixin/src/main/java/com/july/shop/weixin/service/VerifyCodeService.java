package com.july.shop.weixin.service;

import com.alibaba.fastjson.JSONObject;
import com.july.shop.common.base.entity.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: july
 * @date: 2020/2/25 17:09
 * @description:
 */
@Api(tags = "微信注册码验证码接口")
public interface VerifyCodeService {

    /**
     * 功能说明:根据手机号码验证码token是否正确
     */
    @ApiOperation(value = "根据手机号码验证码token是否正确")
    @GetMapping("/verifyWeixinCode")
    @ApiImplicitParams({
            // @ApiImplicitParam(paramType="header",name="name",dataType="String",required=true,value="用户的姓名",defaultValue="zhaojigang"),
            @ApiImplicitParam(paramType = "query", name = "phone", dataType = "String", required = true, value = "用户手机号码"),
            @ApiImplicitParam(paramType = "query", name = "weixinCode", dataType = "String", required = true, value = "微信注册码") })
    public BaseResponse<JSONObject> verifyWeixinCode(@RequestParam("phone") String phone,@RequestParam("weixinCode") String weixinCode);
}

