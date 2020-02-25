package com.july.shop.weixin.service.impl;

import com.july.shop.api.entity.AppEntity;
import com.july.shop.weixin.service.WeiXinAppService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: july
 * @date: 2020/2/25 12:39
 * @description:
 */
@RestController
public class WeiXinAppServiceImpl implements WeiXinAppService {

    @Override
    public AppEntity getApp() {
        return new AppEntity("wx950f504b931484e5", "我叫july young");
    }

}
