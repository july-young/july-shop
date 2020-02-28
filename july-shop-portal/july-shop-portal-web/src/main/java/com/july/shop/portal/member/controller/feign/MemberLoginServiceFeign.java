package com.july.shop.portal.member.controller.feign;

import com.july.shop.api.member.MemberLoginService;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient("app-july-member")
public interface MemberLoginServiceFeign extends MemberLoginService {

}
