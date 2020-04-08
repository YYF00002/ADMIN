package com.tima.admin.dto;

import com.tima.admin.validateInterface.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 用户基本信息表
 * </p>
 *
 * @author YYF
 * @since 2018-07-17
 */
@Getter
@Setter
public class UserBaseInformationDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;

	@ApiModelProperty(value = "编码")
	@NotBlank(groups= {ISelect.class,ISelectWeb.class,IUpdate.class,IUpdateWeb.class})
	private String no;

	@ApiModelProperty(value = "用户名称")
	private String userName;

	@ApiModelProperty(value = "用户名称简称")
	private String shortUserName;

	@ApiModelProperty(value = "真实姓名")
	private String userRealName;

	@ApiModelProperty(value = "性别 1:男 2：女")
	private Integer sex;

	@ApiModelProperty(value = "用户账号")
	@NotBlank(groups= {ILogin.class,IAddWeb.class})
	private String userCode;

	@ApiModelProperty(value = "用户密码")
	@NotBlank(groups= {IAdd.class,ILogin.class,IAddWeb.class})
	private String password;
	
	@ApiModelProperty(value = "用户旧秘密")
	private String oldPassword;
	
	@ApiModelProperty(value = "用户新秘密")
	private String newPassword;
	
	@ApiModelProperty(value = "用户邮箱")
	private String email;

	@ApiModelProperty(value = "用户手机号")
	@NotBlank(groups= {IAdd.class})
	private String phone;

	@ApiModelProperty(value = "用户真实手机号")
	private String realPhone;

	@ApiModelProperty(value = "用户状态 默认0 正常态 1锁定")
	private Integer userStatus;

	@ApiModelProperty(value = "身份证号")
	private String idCards;

	@ApiModelProperty(value = "认证状态 0为注册用户 1为认证用户")
	private Integer authenticationStatus;

	@ApiModelProperty(value = "是否为初始用户，默认0为初始用户 1为非初始用户，初始用户需要初始化信息")
	private Integer initUser;

	@ApiModelProperty(value = "停用时间")
	private Date userDownTime;

	@ApiModelProperty(value = "紧急联系人")
	private String emergencyContactName;

	@ApiModelProperty(value = "紧急联系人电话")
	private String emergencyContactPhone;

	@ApiModelProperty(value = "头像url")
	private String headUrl;
	
	@ApiModelProperty(value = "个性签名")
	private String personalSignature;
	
	@ApiModelProperty(value = "图片NO")
	private String imageNo;
	
	@ApiModelProperty(value = "图片URL")
	private String imageUrl;
	
	@ApiModelProperty(value = "编码S")
	private List<String> nos;
	
    @ApiModelProperty(value = "用户类型：01：app用户;02:后台管理用户")  
   private String userType;
    
    @ApiModelProperty(value = "验证码")
    @NotBlank(groups= {IAdd.class})
	private String code;

    @ApiModelProperty(value = "刷新token")
  	private String refreshToken;
    
    @ApiModelProperty(value = "integral")
  	private String integral;
    
	// @ApiModelProperty(value = "备用字段1")
	// private String attribute1;
	//
	// @ApiModelProperty(value = "备用字段2")
	// private String attribute2;
	//
	// @ApiModelProperty(value = "备用字段3")
	// private String attribute3;
	//
	// @ApiModelProperty(value = "备用字段4")
	// private String attribute4;
	//
	// @ApiModelProperty(value = "备用字段5")
	// private String attribute5;
	//
	// @ApiModelProperty(value = "备用字段6")
	// private String attribute6;

	// @ApiModelProperty(value = "创建人")
	// private String createdBy;
	//
//	 @ApiModelProperty(value = "创建时间")
//	 private Date createdDate;
	//
	// @ApiModelProperty(value = "修改人")
	// private String lastModifiedBy;
	//
	 @ApiModelProperty(value = "最后修改时间")
	 private Date lastModifiedDate;
	//
	// @ApiModelProperty(value = "版本号")
	// private Long version;
	//
	// @ApiModelProperty(value = "逻辑删除")
	// private String deleteFlag;

	@ApiModelProperty(value = "同步开始的时间")
	private Date beginDate;


	@ApiModelProperty(value = "同步结束的时间")
	private Date endDate;

	@ApiModelProperty(value = "图片验证码唯一标识")
	private String codeImgId;

	@ApiModelProperty(value = "当前时间")
	private String nowDate;



	@ApiModelProperty(value = "aaaId")
	@NotNull(groups = {IThirdPartyLogin.class})
	private Long aaaId;

	@ApiModelProperty(value = "token")
	private String token;



}
