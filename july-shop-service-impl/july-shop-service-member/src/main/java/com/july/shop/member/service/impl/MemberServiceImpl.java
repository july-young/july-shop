package com.july.shop.member.service.impl;

import com.july.shop.api.member.MemberService;
import com.july.shop.member.feign.WeiXinAppServiceFeign;
import com.july.shop.weixin.entity.AppEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author: july
 * @date: 2020/2/25 10:40
 * @description:
 */
@RestController
public class MemberServiceImpl implements MemberService {
    @Autowired
    private WeiXinAppServiceFeign weiXinAppServiceFeign;

    @Override
    public AppEntity memberInvokeWeixin() {
        return weiXinAppServiceFeign.getApp();
    }

}