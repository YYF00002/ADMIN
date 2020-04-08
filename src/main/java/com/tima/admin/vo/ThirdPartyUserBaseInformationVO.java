package com.tima.admin.vo;

import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import lombok.Data;
import java.io.Serializable;

/**
 * <p>
 * 第三方用户信息表
 * </p>
 *
 * @author YYF
 * @since 2018-08-30
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ThirdPartyUserBaseInformationVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;

	private String no;

	@ApiModelProperty(value = "AAA用户id")
	private Long AAAId;

	@ApiModelProperty(value = "tsp用户id")
	private Long tspId;

	@ApiModelProperty(value = "APP用户ID")
	private Long userId;

	@ApiModelProperty(value = "登录用户名")
	private String username;

	@ApiModelProperty(value = "密码（MD5）")
	private String password;

	@ApiModelProperty(value = "邮箱")
	private String email;

	@ApiModelProperty(value = "真实姓名")
	private String realName;

	@ApiModelProperty(value = "地址")
	private String address;

	@ApiModelProperty(value = "手机号码")
	private String phone;

	@ApiModelProperty(value = "年龄")
	private Integer age;

	@ApiModelProperty(value = "性别 1 男 2 女")
	private Integer sex;

	@ApiModelProperty(value = "过期 1 过期   0 可用")
	private Integer expired;

	@ApiModelProperty(value = "不可用 1不可用 0可用")
	private Integer disabled;

	@ApiModelProperty(value = "用户信息json字符串")
	private String userBindSystems;

	@ApiModelProperty(value = "AAA用户token")
	private String token;

	@ApiModelProperty(value = "AAA用户刷新token")
	private String refreshToken;

	@ApiModelProperty(value = "token过期时间")
	private String expiresIn;

	@ApiModelProperty(value = "创建人")
	private String createdBy;

	@ApiModelProperty(value = "创建时间")
	private Date createdDate;

	@ApiModelProperty(value = "修改人")
	private String lastModifiedBy;

	@ApiModelProperty(value = "最后修改时间")
	private Date lastModifiedDate;

	@ApiModelProperty(value = "版本号")
	private Long version;

	@ApiModelProperty(value = "逻辑删除")
	private String deleteFlag;

}