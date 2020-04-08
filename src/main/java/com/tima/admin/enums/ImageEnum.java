package com.tima.admin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ImageEnum{
	
    HAEDURL(01, "用户头像");


    private Integer code;

    private String message;

}
