package com.tima.admin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
/**
 * 菜单枚举
 * @author admin
 *
 */
@AllArgsConstructor
@Getter
public enum MenuEnum {
	BACKGROUND_SYSTEM(0,"后台系统菜单"),
	FRONT_DESK_BUSINESS(1,"前台业务菜单"),
	IS_NOT_MENU(0,"不是菜单"),
	IS_MENU(1,"是菜单"),
	
	;
	
	
	  ;

    private Integer code;

    private String message;
}
