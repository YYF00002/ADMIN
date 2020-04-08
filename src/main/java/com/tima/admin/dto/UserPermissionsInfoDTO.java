package com.tima.admin.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 * 权限信息表
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
@Getter
@Setter
 public class UserPermissionsInfoDTO extends BaseDTO implements Serializable{
   private static final long serialVersionUID = 1L;
   private Long id;
   
    @ApiModelProperty(value = "编码")  
   private String no;
   
    @ApiModelProperty(value = "权限编码（根据需要使用）")  
   private String permissionsCode;
   
    @ApiModelProperty(value = "权限名称")  
   private String permissionsName;
   
    @ApiModelProperty(value = "权限描述")  
   private String permissionsDesc;
   
    @ApiModelProperty(value = "组织主键（根据需要使用）")  
   private Long groupId;
   
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
