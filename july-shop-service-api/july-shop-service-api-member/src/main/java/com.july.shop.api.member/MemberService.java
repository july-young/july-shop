package com.july.shop.api.member;

import com.july.shop.weixin.entity.AppEntity;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author: july
 * @date: 2020/2/25 10:30
 * @description: 会员服务接口
 */
@Api(tags = "会员服务接口")
public interface MemberService {

    /**
     * 会员服务接口调用微信接口
     *
     * @return
     */
    @ApiOperation(value = "会员服务调用微信服务")
    @GetMapping("/memberInvokeWeixin")
    public AppEntity memberInvokeWeixin();

}
