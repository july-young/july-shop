package com.july.shop.member.feign;

import com.july.shop.weixin.service.VerifyCodeService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: july
 * @date: 2020/2/25 19:48
 * @description:
 */
@FeignClient("app-july-weixin")
public interface VerifyCodeServiceFeign extends VerifyCodeService {

}
