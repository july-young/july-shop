package com.july.shop.weixin.feign;

import com.july.shop.api.member.MemberService;
import org.springframework.cloud.openfeign.FeignClient;


/**
 * @author july
 */
@FeignClient("app-july-member")
public interface MemberServiceFeign extends MemberService {

}
