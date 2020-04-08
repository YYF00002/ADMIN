package com.tima.admin.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoJwtDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String no;
	private String userName;
	private String shortUserName;
	private String userRealName;
	private String userType;
	private String userCode;
	private String userRole;
}
