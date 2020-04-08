package com.tima.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tima.admin.validateInterface.IMessageCode;

/**
 * <p>
 * 第三方请求记录表
 * </p>
 *
 * @author YYF
 * @since 2018-08-14
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ThirdPartyRequestDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;

	private String no;

	@ApiModelProperty(value = "请求来源：1.DMS 2.AAA 3.TSP")
	private Integer requestSource;

	@ApiModelProperty(value = "请求方法")
	private String requestMethod;

	@ApiModelProperty(value = "请求参数")
	private String requestJson;

	@ApiModelProperty(value = "响应参数")
	private String responseJson;

	@ApiModelProperty(value = "token")
	private String token;

	@ApiModelProperty(value = "刷新token")
	private String refreshToken;

	@ApiModelProperty(value = "授权码")
	private String authorization;

	@ApiModelProperty(value = "错误描述")
	private String errorDescription;

	@ApiModelProperty(value = "错误码")
	private Integer errorCode;

	// AAA属性
	 @ApiModelProperty(value = "AAA属性dto")
	 private AAADTO AAAdto;
	
	 //手机号 发送验证码用
	@ApiModelProperty(value = "手机号")
	@NotNull(groups= {IMessageCode.class})
	private String phone;

	@ApiModelProperty(value = "信息类型")
	@NotBlank(groups= {IMessageCode.class})
	private String sendSmsType;


	// @ApiModelProperty(value = "创建人")
	// private String createdBy;
	//
	// @ApiModelProperty(value = "创建时间")
	// private Date createdDate;
	//
	// @ApiModelProperty(value = "修改人")
	// private String lastModifiedBy;
	//
	// @ApiModelProperty(value = "最后修改时间")
	// private Date lastModifiedDate;
	//
	// @ApiModelProperty(value = "版本号")
	// private Long version;
	//
	// @ApiModelProperty(value = "逻辑删除")
	// private String deleteFlag;

}
