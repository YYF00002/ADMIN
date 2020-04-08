package com.tima.admin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TokenEnum {
    USER_TOKEN("tokenUser"),
	USER_REFRESH_TOKEN("tokenReFreshUser");
	private String token;
}
