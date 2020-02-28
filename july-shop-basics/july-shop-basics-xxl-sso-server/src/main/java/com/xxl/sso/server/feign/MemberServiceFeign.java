package com.xxl.sso.server.feign;

import com.july.shop.api.member.MemberService;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient("app-july-member")
public interface MemberServiceFeign extends MemberService {

}
