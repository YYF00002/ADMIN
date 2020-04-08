package com.tima.admin.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 版本控制枚举
 */
@AllArgsConstructor
@Getter
public enum VersionEnum {
    VERSION_TYPE_ANDROID("1","安卓"),
    VERSION_TYPE_H5("2","H5"),
    VERSION_TYPE_IOS("3","IOS"),
    IS_UPDATE("1","需要更新"),
    NOT_UPDATE("2","不需要更新")
;
    private String code;
    private String msg;
}
