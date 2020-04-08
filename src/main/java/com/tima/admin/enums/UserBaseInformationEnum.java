package com.tima.admin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
/**
 * 用户登录注册枚举
 * @author liming
 *
 */
@AllArgsConstructor
@Getter
public enum UserBaseInformationEnum {
	DEFAULT_PASSWORD("123456","WEB默认密码"),
	APP_USER("01","APP用户"),
	WEB_USER("02","WEB用户"),
	
	//推荐码类型
	RECOMMENDED_CODE("10","APP")
	  ;

    private String code;

    private String message;
}
