package com.july.shop.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: july
 * @date: 2020/2/25 10:38
 * @description:
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableSwagger2Doc
@EnableApolloConfig
@ComponentScan({"com.july.shop.member","com.july.shop.common"})
@MapperScan(basePackages = {"com.july.shop.member.mapper"})
public class AppMember {

    public static void main(String[] args) {
        SpringApplication.run(AppMember.class, args);
    }

}