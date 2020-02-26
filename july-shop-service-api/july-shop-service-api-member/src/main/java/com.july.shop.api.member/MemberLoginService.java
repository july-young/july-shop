package com.july.shop.api.member;

import com.alibaba.fastjson.JSONObject;
import com.july.shop.api.dto.member.input.UserLoginInpDTO;
import com.july.shop.common.base.entity.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author: july
 * @date: 2020/2/26 10:28
 * @description:
 */
@Api(tags = "会员登陆接口")
public interface MemberLoginService {
    /**
     * 用户登陆接口
     *
     * @param userLoginInpDto
     * @return
     */
    @PostMapping("/login")
    @ApiOperation(value = "会员用户登陆信息接口")
    BaseResponse<JSONObject> login(@RequestBody UserLoginInpDTO userLoginInpDto);

}
