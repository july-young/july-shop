package com.july.shop.portal.member.controller.req.vo;

import lombok.Data;

/**
 * @author july
 */
@Data
public class LoginVo {

	/**
	 * 手机号码
	 */
	private String mobile;
	/**
	 * 手机密码
	 */
	private String password;
	/**
	 * 图形验证码
	 */
	private String graphicCode;

}
