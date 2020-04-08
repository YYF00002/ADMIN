package com.tima.admin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CommonEnum {
	
    OPEN("1", "启用"),
    CLOSE("0", "禁用"),
    WECHAT("0","微信"),
    QQ("1","qq");


    private String code;

    private String message;

}
