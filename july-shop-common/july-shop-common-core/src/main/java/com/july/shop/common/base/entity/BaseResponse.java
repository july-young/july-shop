package com.july.shop.common.base.entity;

import lombok.Data;

/**
 * @author july
 * @description:微服务接口封装,T为返回接口data的数据类型
 */
@Data
public class BaseResponse<T> {

	private Integer code;
	private String msg;
	private T data;

	public BaseResponse() {

	}

	public BaseResponse(Integer code, String msg, T data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

}
