package com.july.shop.portal.member.controller;

import javax.servlet.http.HttpSession;

import com.july.shop.api.dto.member.input.UserInpDTO;
import com.july.shop.common.base.entity.BaseResponse;
import com.july.shop.common.base.portal.BaseWebController;
import com.july.shop.common.utils.JulyBeanUtils;
import com.july.shop.common.utils.RandomValidateCodeUtil;
import com.july.shop.portal.member.controller.feign.MemberRegisterServiceFeign;
import com.july.shop.portal.member.controller.req.vo.RegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.alibaba.fastjson.JSONObject;

/**
 * @author july
 * @description: 注册请求
 */
@Controller
public class RegisterController extends BaseWebController {
	private static final String MB_REGISTER_FTL = "member/register";
	@Autowired
	private MemberRegisterServiceFeign memberRegisterServiceFeign;
	/**
	 * 跳转到登陆页面页面
	 */
	private static final String MB_LOGIN_FTL = "member/login";

	/**
	 * 跳转到注册页面
	 * 
	 * @return
	 */
	@GetMapping("/register")

	public String getRegister() {
		return MB_REGISTER_FTL;
	}

	/**
	 * 跳转到注册页面
	 * 
	 * @return
	 */
	@PostMapping("/register")
	public String postRegister(@ModelAttribute("registerVo") @Validated RegisterVo registerVo,
			BindingResult bindingResult, Model model, HttpSession httpSession) {
		// 1.接受表单参数 (验证码) 创建对象接受参数 vo do dto
		if (bindingResult.hasErrors()) {
			// 如果参数有错误的话
			// 获取第一个错误!
			String errorMsg = bindingResult.getFieldError().getDefaultMessage();
			setErrorMsg(model, errorMsg);
			return MB_REGISTER_FTL;
		}
		// 建议不要if lese 判断 嵌套判断统一return
		// 2.判断图形验证码是否正确
		String graphicCode = registerVo.getGraphicCode();
		Boolean checkVerify = RandomValidateCodeUtil.checkVerify(graphicCode, httpSession);
		if (!checkVerify) {
			setErrorMsg(model, "图形验证码不正确!");
			return MB_REGISTER_FTL;
		}
		// 3.调用会员服务接口实现注册 将前端提交vo 转换dto
		UserInpDTO userInpDTO = JulyBeanUtils.voToDto(registerVo, UserInpDTO.class);
		BaseResponse<JSONObject> register = memberRegisterServiceFeign.register(userInpDTO, registerVo.getRegistCode());
		if (!isSuccess(register)) {
			setErrorMsg(model, register.getMsg());
			return MB_REGISTER_FTL;
		}

		// 4.跳转到登陆页面
		return MB_LOGIN_FTL;
	}

}
