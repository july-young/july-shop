package com.july.shop.portal.member.controller.feign;

import com.july.shop.api.member.QQAuthoriService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author july
 */
@FeignClient("app-july-member")
public interface QQAuthoriFeign extends QQAuthoriService {

}
