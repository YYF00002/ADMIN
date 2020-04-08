package com.tima.admin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
* @Description:	   消息推送枚举类
* @Author:         YYF
* @CreateDate:     2018/12/17 18:01
* @Version:        1.0
*/
@AllArgsConstructor
@Getter
public enum SendMessageEnum {
	MESSAGE_TITLE(1,"周年祝福","尊敬的用户，今天您已注册江淮汽车APP一周年，江淮汽车感谢您一年来的陪伴，祝您生活愉快。"),
	//推送类型
	PERSONAL_PUSH(0,"个人推送","用于针对用户的推送"),
	LABEL_PUSH(1,"便签推送","用户根据标签推送消息")



	;
	
	
	  ;

    private Integer code;
	private String title;
    private String message;
}
