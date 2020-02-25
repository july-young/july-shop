package com.july.shop.member.feign;

import com.july.shop.weixin.service.WeiXinAppService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: july
 * @date: 2020/2/25 10:41
 * @description:
 */

@FeignClient(name = "app-july-weixin")
public interface WeiXinAppServiceFeign extends WeiXinAppService {


}
