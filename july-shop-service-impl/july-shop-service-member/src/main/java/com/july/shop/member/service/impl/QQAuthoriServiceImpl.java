package com.july.shop.member.service.impl;

import com.july.shop.api.member.QQAuthoriService;
import com.july.shop.api.member.entity.UserDo;
import com.july.shop.common.base.api.BaseApiService;
import com.july.shop.common.base.entity.BaseResponse;
import com.july.shop.common.constants.Constants;
import com.july.shop.common.token.GenerateToken;
import com.july.shop.member.mapper.UserMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

/**
 * @author july
 */
@RestController
public class QQAuthoriServiceImpl extends BaseApiService<JSONObject> implements QQAuthoriService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private GenerateToken generateToken;

	@Override
	public BaseResponse<JSONObject> findByOpenId(String qqOpenId) {
		// 1.根据qqOpenId查询用户信息
		if (StringUtils.isEmpty(qqOpenId)) {
			return setResultError("qqOpenId不能为空!");
		}
		// 2.如果没有查询到 直接返回状态码203
		UserDo userDo = userMapper.findByOpenId(qqOpenId);
		if (userDo == null) {
			return setResultError(Constants.HTTP_RES_CODE_NOTUSER_203, "根据qqOpenId没有查询到用户信息");
		}
		// 3.如果能够查询到用户信息的话 返回对应用户信息token
		String keyPrefix = Constants.MEMBER_TOKEN_KEYPREFIX + "QQ_LOGIN";
		Long userId = userDo.getUserId();
		String userToken = generateToken.createToken(keyPrefix, userId + "");
		JSONObject data = new JSONObject();
		data.put("token", userToken);
		return setResultSuccess(data);
	}

}
