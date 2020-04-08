package com.tima.admin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: pluto-program
 * @description: 积分规则 枚举
 * code对应数据库  记录，serviceStr前端业务类型，msg 对应 前端 展示字段
 * @author: J&L
 * @create: 2018-08-31 15:36
 **/
@AllArgsConstructor
@Getter
public enum IntegralEnums {

    CUSTOMIN_TEGRAL(0,"CUSTOMIN_TEGRAL","自定义类型",1), //大类型

    SERVICE_FIXED(1, "SERVICE_FIXED", "固定积分", 1),//大类型

    REGISTER(1, "REGISTER", "注册", 1),

    REAL_NAME(2, "REAL_NAME", "个人信息完善", 1),

    VEHICLE_CERTIFICATION(3, "VEHICLE_CERTIFICATION", "车辆认证", 1),

    SHARING_FORWARDING(4, "SHARING_FORWARDING", "分享转发", 1),

    SIGN_IN(5, "SIGN_IN", "签到", 1),
    CONTINUOUS_SIGN_IN(29,"CONTINUOUS_SIGN_IN","连续签到7天赠送",1),

    ACTIVITY_REGISTRATION(6, "ACTIVITY_REGISTRATION", "活动报名", 1),

    BLUEPRINT_COMMENT(7, "BLUEPRINT_COMMENT", "优质图文", 1),


    SERVICE_TYPE_CONSUMPTION(3, "SERVICE_TYPE_CONSUMPTION", "消费行为", 3),//大类型

    INTEGRAL_CONSUMPTION(8, "INTEGRAL_CONSUMPTION", "积分消费", 3),


    SERVICE_TYPE_SPECIAL_CONSUMPTION(4, "SERVICE_TYPE_SPECIAL_CONSUMPTION", "特殊消费", 4),

//    SERVICE_EQUAL_RATIO(4,"SERVICE_EQUAL_RATIO","金额消费获取对应积分",4),//大类型
//
//    		NEW_CAR_INTEGRAL(9,"NEW_CAR_INTEGRAL","新车销售积分",4),
//
//    TYPE_RETAIN(1,"TYPE_RETAIN","提升留存"),
//
//    TYPE_NEWLY_ADDED(2,"TYPE_NEWLY_ADDED","提升新增"),
//
//    TYPE_ACTIVE(3,"TYPE_ACTIVE","提升活跃"),
//
//    WX_MALL(8,"WX_MALL","微信商城消费接口"),

    //推荐购车:认证客户介绍他人购买江淮汽车品牌新车可累积积分
    RECOMMEND_BUYING_CAR(30, "RECOMMEND_BUYING_CAR", "成功推荐购车", 4),

    //客户再购:不与推荐购车同时享受
    SECONDARY_PURCHASE(31, "SECONDARY_PURCHASE", "再次购买", 4),

    //在线订车(成交):在线订车并成功交易
    BOOK_ONLINE(32, "BOOK_ONLINE", "在线订车", 4),

    //成功购车:字面意思
    SUCCESS_CAR_PURCHASE(33, "SUCCESS_CAR_PURCHASE", "成功购车", 4),

    //预约维保奖励:APP内预约维修并准时进店
    RESERVATION_MAINTENANCE(34, "RESERVATION_MAINTENANCE", "预约维保", 4),

    //维保消费:会员在经销商端维修保养、购买原装配附件，其自付费部分可按设定规则消费1元积1分
    MAINTENANCE_CONSUMPTION(35, "MAINTENANCE_CONSUMPTION", "维保消费", 4),

    // 网点评分:会员预约4S店进店维修/保养后对本次服务进行评价可累积积分
    NETWORK_EVALUATION(36, "NETWORK_EVALUATION", "网点评分", 4),


    //积分规则的开关
    off(0, "off", "关", 10),
    on(1, "on", "开", 10);

    private Integer code;

    private String serviceStr;

    private String msg;


    private Integer father;


    /**
     * 根据key获取value
     *
     * @param serviceStr
     * @return String
     */
    public static Integer getCodeByServiceStr(String serviceStr) {
        IntegralEnums[] enums = values();
        for (int i = 0; i < enums.length; i++) {
            if (enums[i].getServiceStr().equals(serviceStr)) {
                return enums[i].getCode();
            }
        }
        return 0;
    }


    /**
     * 根据key获取msg
     *
     * @param serviceStr
     * @return String
     */
    public static String getMsgByServiceStr(String serviceStr) {
        IntegralEnums[] enums = values();
        for (int i = 0; i < enums.length; i++) {
            if (enums[i].getServiceStr().equals(serviceStr)) {
                return enums[i].getMsg();
            }
        }
        return "";
    }

    /**
     * 根据key获取父类code
     *
     * @param serviceStr
     * @return String
     */
    public static Integer getfatherByServiceStr(String serviceStr) {
        IntegralEnums[] enums = values();
        for (int i = 0; i < enums.length; i++) {
            if (enums[i].getServiceStr().equals(serviceStr)) {
                return enums[i].getFather();
            }
        }
        return 0;
    }
}
