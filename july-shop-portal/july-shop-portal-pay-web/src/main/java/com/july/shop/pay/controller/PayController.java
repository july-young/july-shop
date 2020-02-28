package com.july.shop.pay.controller;

import com.july.shop.common.utils.CookieUtils;
import com.july.shop.pay.web.constants.WebConstants;
import com.xxl.sso.core.login.SsoWebLoginHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author july
 * @description: 支付网站
 */
@Controller
public class PayController {

	/**
	 * 跳转到index页面
	 */
	private static final String INDEX_FTL = "index";
	private static final String REDIRECT_INDEX_FTL = "redirect:/";

	@RequestMapping("/")
	public String index() {
		return INDEX_FTL;
	}

	@RequestMapping("/exit")
	public String exit(HttpServletRequest request, HttpServletResponse response, Model model) {
		// 1.从cookie 中 获取 会员token
		String token = CookieUtils.getCookieValue(request, WebConstants.LOGIN_TOKEN_COOKIENAME, true);
		// logout
		SsoWebLoginHelper.logout(request, response);
		// TODO 完成退出功能 实现唯一登陆心跳检测 前端定时器 定时 使用js 读取本地cookie 信息 使用token 查询当前状态 如果token状态为1的话，页面直接刷新下。
		CookieUtils.deleteCookie(request, response, WebConstants.LOGIN_TOKEN_COOKIENAME);
		return REDIRECT_INDEX_FTL;
	}
}
