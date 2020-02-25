package com.july.shop.weixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: july
 * @date: 2020/2/25 10:48
 * @description:
 */
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2Doc
@EnableApolloConfig
@EnableFeignClients
@ComponentScan(value = {"com.july.shop.common","com.july.shop.weixin"})
public class AppWeixin {

    public static void main(String[] args) {
        SpringApplication.run(AppWeixin.class, args);
    }
}