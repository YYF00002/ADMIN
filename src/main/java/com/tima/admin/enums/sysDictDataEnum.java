package com.tima.admin.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum sysDictDataEnum {
	MEMBER_OF_BLESSING("10069","注册一周年提醒祝福")
	;
	
	private String dictCode;
	private String message;

	
	
}
