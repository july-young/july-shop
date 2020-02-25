package com.july.shop.api.weixin.entity;

import lombok.Data;

/**
 * @author: july
 * @date: 2020/2/25 10:32
 * @description: App实体类层
 */
@Data
public class AppEntity {

    /**
     * appid
     */
    private String appId;
    /**
     * 应用名称
     */
    private String appName;

    public AppEntity() {

    }

    public AppEntity(String appId, String appName) {
        super();
        this.appId = appId;
        this.appName = appName;
    }

}