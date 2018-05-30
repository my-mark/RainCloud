package com.junsheng.community.poss.domain;


import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * json 响应
 */
public class ApiResponse<T> {
	private static Logger logger = LoggerFactory.getLogger(ApiResponse.class);
	protected String code;
	protected String msg;
	protected T result;

	public ApiResponse() {
		super();
	}

	public ApiResponse(String code, String msg){
		super();
		this.code = code;
		this.msg = msg;
		logger.info("------------------------------------------------返回数据11------------------------------------------------");
		logger.info(JSON.toJSONString(this));
	}

	public ApiResponse(String code, String msg, T result){
		super();
		this.code = code;
		this.msg = msg;
		this.result = result;
		logger.info("------------------------------------------------返回数据11------------------------------------------------");
		logger.info(JSON.toJSONString(this));
	}

	public ApiResponse(Header header) {
		this(header.getCode(),header.getMemo());
	}

	public ApiResponse(Header header, T result) {
		this(header.getCode(),header.getMemo(),result);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public static ApiResponse success() {
		return new ApiResponse(new Header(HeaderEnum.SUC_MSG));
	}

	public static ApiResponse error(){
		return new ApiResponse(new Header(HeaderEnum.SERVICE_MSG));
	}

	public static ApiResponse error(HeaderEnum headerEnum){
		return new ApiResponse(new Header(headerEnum.getCode(), headerEnum.getMsg()));
	}


	public static ApiResponse error(String errorCode, String errorMessage){
		return new ApiResponse(new Header(errorCode, errorMessage));
	}

	public static<T> ApiResponse success(T param) {
		return new ApiResponse(new Header(HeaderEnum.SUC_MSG), param);
	}

	public static<T> ApiResponse success(String key, T param) {
		Map<String, Object> map = new HashMap<>();
		map.put(key, param);
		return new ApiResponse(new Header(HeaderEnum.SUC_MSG), map);
	}


	public static<T> ApiResponse success(T[][] pairs) {
		return new ApiResponse(new Header(HeaderEnum.SUC_MSG), pairs);
	}
	public static<T> ApiResponse success(HeaderEnum headerEnum, String key, T param) {
		Map<String, Object> map = new HashMap<>();
		map.put(key, param);
		return new ApiResponse(new Header(headerEnum), map);
	}

	@Override
	public String toString() {
		return "{" +
				"code='" + code + '\'' +
				", msg='" + msg + '\'' +
				", result=" + ((result instanceof String)?("\'" + result + "\'" ):result) +
				'}';
	}
}
