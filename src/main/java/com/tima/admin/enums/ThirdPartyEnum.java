package com.tima.admin.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ThirdPartyEnum {
	DMS(1,"DMS"),
	AAA(2,"AAA"),
	TSP(3,"TSP"),
	AUTHORIZATION_BEARER_BY_AAA(200,"Bearer "),
	AUTHORIZATION_BASIC_BY_AAA(201,"Basic "),
	REFRESHTOKEN_BY_AAA(202,"/oauth/token"),
	CHECKTOKEN_BY_AAA(203,"/oauth/check_token"),
	SEARCHUSER_BY_AAA(204,"/oauth/profile"),
	UPDATEUSER_BY_AAA(205,"/user/update"),
	DELETEUSER_BY_AAA(206,"/user/del"),
	SENDSMS_BY_AAA(207,"/sms/send"),
	VALIDATESMS_BY_AAA(208,"/sms/validate"),
	LOGOUT_BY_AAA(209,"/oauth/revoke"),
	REGISTER_BY_AAA(210,"/user/save"),
	LOGIN_BY_AAA(211,"/oauth/token"),
	BINDSYSTEM_BY_AAA(212,"/user/bindsystem"),
	UPDATE_BINDSYSTEM_BY_AAA(213,"/user/updatebindsystem"),
	DELETE_BINDSYSTEM_BY_AAA(214,"/user/delbindsystem"),
	SENDNEWSMS_BY_AAA(215,"/sms/sendNewCode"),
	
	//验证码类型
	REGISTER_CODE_TYPE(300,"1"),
	LOGIN_CODE_TYPE(301,"2"),
	UPDATE_PASSWORD_CODE_TYPE(303,"3"),
	
	//八各系统的编码
//	乘用车tsp用户 CHYCH_TSP_YH
	CHYCH_TSP_YH(400,"CHYCH_TSP_YH"),
//	江淮汽车客户手机app JHQCHKHSJ_APP
	JHQCHKHSJ_APP(401,"JHQCHKHSJ_APP"),
//	tsp用户 CHYCH_TSP_YH
	TSP_ALL(402,"TSP"),
	//	轻卡tsp用户
	TSP_QK(403,"TSP_QK"),
	//	重卡tsp
	TSP_ZK(404,"TSP_ZK"),
	;
	
	private Integer thirdPartyNo;
	private String thirdPartyName;
	
}
