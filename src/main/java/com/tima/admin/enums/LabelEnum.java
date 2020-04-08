package com.tima.admin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 标签枚举
 * @author admin
 *
 */
@AllArgsConstructor
@Getter
public enum LabelEnum {
	//标签类型
	MEMBER_LABEL(1,"会员等级标签"),
	CAR_OWNER(2,"车主标签"),
	COMMUNITY_USER(3,"社区用户标签"),
	USER_BASE_INFORMATION(4,"用户基本信息标签"),

	//标签
	REGULAR_MEMBERS(1,"普通会员"),
	CERTIFIED_MEMBERS(2,"认证会员"),
	SILVER_MEMBER(3,"白银会员"),
	GOLD_MEMBERSHIP(4,"黄金会员"),
	DIAMOND_MEMBERSHIP(5,"钻石会员"),
	OWNER(6,"车主"),
	MAN(13,"男"),
	WOMAN(14,"女")

	;
	
	
	  ;

    private Integer code;

    private String message;
}
