package com.july.shop.weixin.service;

import com.july.shop.api.weixin.entity.AppEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: july
 * @date: 2020/2/25 12:35
 * @description:
 */
@Api(tags = "微信服务接口")
public interface WeiXinAppService {

    /**
     * 功能说明： 应用服务接口
     */
    @ApiOperation(value = "微信应用服务接口")
    @GetMapping("/getApp")
    public AppEntity getApp();

}