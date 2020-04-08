package com.tima.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * AAA请求DTO	
 * </p>
 *
 * @author YYF
 * @since 2018-08-14
 */
@Getter
@Setter
public class AAADTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	// AAA属性
	@ApiModelProperty(value = "用户名id")
	private Long userId;
	@ApiModelProperty(value = "tspID")
	private Long tspId;
	@ApiModelProperty(value = "用户名")
	private String username;
	@ApiModelProperty(value = "邮箱")
	private String email;
	@ApiModelProperty(value = "密码")
	private String password;
	@ApiModelProperty(value = "地址")
	private String address;
	@ApiModelProperty(value = "验证码")
	private String code;
	@ApiModelProperty(value = "信息类型")
	private String sendSmsType;
	
	@ApiModelProperty(value = "手机号")
	private String phone;
	@ApiModelProperty(value = "年龄")
	private String age;
	@ApiModelProperty(value = "性别")
	private String sex;

	@ApiModelProperty(value = "头像URL")
	private String headiconurl;

	@ApiModelProperty(value = "昵称")
	private String nickname;

	@ApiModelProperty(value = "个性签名")
	private String signature;
	
	@ApiModelProperty(value = "请求类型")
	private String grant_type;
	
	@ApiModelProperty(value = "可以访问的区域")
	private String scope;
	
	
	@ApiModelProperty(value = "用户存在于系统列表")
	private List<userBindSystemDTO> userBindSystems;
	
	
	@ApiModelProperty(value = "token")
	private String access_token;
	@ApiModelProperty(value = "刷新token")
	private String refresh_token;
	@ApiModelProperty(value = "过期时间")
	private String expires_in;


}
