package com.tima.admin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Date;

@AllArgsConstructor
@Getter
public enum levelChangeEnum {

    DESCRIBE(1,"级别变动通知时间："+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())),
    PUSH_NOT(0,"未推送"),
    PUSH_OK(1,"已推送"),

            ;



    private Integer code;
    private String message;

}
