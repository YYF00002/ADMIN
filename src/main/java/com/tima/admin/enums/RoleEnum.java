package com.tima.admin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
/**
 * 角色枚举
 * @author YYF
 *
 */
@AllArgsConstructor
@Getter
public enum RoleEnum {
	SYSTEM_PRESET(1, "系统预置	"),
	USER_CREATE(2, "用户创建"),
	;

	private Integer code;

	private String message;

}
