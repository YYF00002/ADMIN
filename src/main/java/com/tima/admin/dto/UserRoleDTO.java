package com.tima.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
@Getter
@Setter
public class UserRoleDTO extends BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;

	@ApiModelProperty(value = "编码")
	private String no;

	@ApiModelProperty(value = "角色名称")
	private String roleName;

	@ApiModelProperty(value = "角色说明")
	private String roleDesc;

	@ApiModelProperty(value = "角色编码（根据需要使用）")
	private String roleCode;

	@ApiModelProperty(value = "角色类别 0为系统预置 1为用户创建")
	private Integer roleType;

	@ApiModelProperty(value = "备用字段1")
	private String attribute1;

	@ApiModelProperty(value = "备用字段2")
	private String attribute2;

	@ApiModelProperty(value = "备用字段3")
	private String attribute3;

	@ApiModelProperty(value = "备用字段4")
	private String attribute4;

	@ApiModelProperty(value = "备用字段5")
	private String attribute5;

	@ApiModelProperty(value = "备用字段6")
	private String attribute6;
	
	@ApiModelProperty(value = "用户No")
	private String userNO;

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
