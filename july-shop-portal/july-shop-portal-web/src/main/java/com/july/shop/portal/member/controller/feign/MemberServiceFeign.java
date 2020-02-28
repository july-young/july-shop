package com.july.shop.portal.member.controller.feign;

import com.july.shop.api.member.MemberService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: july
 * @date: 2020/2/26 14:39
 * @description:
 */
@FeignClient("app-july-member")
public interface MemberServiceFeign extends MemberService {

}
