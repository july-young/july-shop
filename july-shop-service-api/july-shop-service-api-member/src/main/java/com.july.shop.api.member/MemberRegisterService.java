package com.july.shop.api.member;

import com.alibaba.fastjson.JSONObject;
import com.july.shop.api.member.entity.UserEntity;
import com.july.shop.common.base.entity.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: july
 * @date: 2020/2/25 19:44
 * @description:
 */
@Api(tags = "会员注册接口")
public interface MemberRegisterService {
    /**
     * 用户注册接口
     *
     * @param userEntity
     * @return
     */
    @PostMapping("/register")
    @ApiOperation(value = "会员用户注册信息接口")
    BaseResponse<JSONObject> register(@RequestBody UserEntity userEntity,
                                      @RequestParam("registCode") String registCode);

}
