package com.tima.admin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
* @Description:    redis key的前缀
* @Author:         YYF
* @CreateDate:     2019/5/22 10:30
* @Version:        1.0
*/
@AllArgsConstructor
@Getter
public enum RedisEnum {
	
    VALIDATED_CODE("validateCode","手机验证码");


    private String  pre ;
    private String message;

}
