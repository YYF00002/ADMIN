package com.tima.admin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserAddressEnum {
	IS_NOT_DEFAULT(0, "非默认地址"), 
	IS_DEFAULT(1, "是默认地址");
	 ;

    private Integer code;

    private String message;
}
