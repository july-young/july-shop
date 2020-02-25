package com.july.shop.common.base.entity;

import lombok.Data;

/**
 * @author july
 * @description:微服务接口封装,T为返回接口data的数据类型
 */
@Data
public class BaseResponse<T> {

	private Integer rtnCode;
	private String msg;
	private T data;

	public BaseResponse() {

	}

	public BaseResponse(Integer rtnCode, String msg, T data) {
		super();
		this.rtnCode = rtnCode;
		this.msg = msg;
		this.data = data;
	}

}
