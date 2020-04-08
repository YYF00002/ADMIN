package com.tima.admin.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 * 角色权限关联表
 * </p>
 *
 * @author YYF
 * @since 2018-08-01
 */
@Getter
@Setter
 public class RolePermissionsRelationDTO extends BaseDTO implements Serializable{
   private static final long serialVersionUID = 1L;
   private Long id;
   
    @ApiModelProperty(value = "用户角色id")  
   private Long roleId;
    
    @ApiModelProperty(value = "用户角色no")  
    private String roleNo;
   
    @ApiModelProperty(value = "用户权限id")  
   private Long permissionsId;
    
    @ApiModelProperty(value = "用户权限no")  
    private String permissionsNo;
   
    @ApiModelProperty(value = "状态（根据需要使用）")  
   private Integer status;
   
//    @ApiModelProperty(value = "创建人")  
//   private String createdBy;
//   
//    @ApiModelProperty(value = "创建时间")  
//   private Date createdDate;
//   
//    @ApiModelProperty(value = "修改人")  
//   private String lastModifiedBy;
//   
//    @ApiModelProperty(value = "最后修改时间")  
//   private Date lastModifiedDate;
//   
//    @ApiModelProperty(value = "版本号")  
//   private Long version;
//   
//    @ApiModelProperty(value = "逻辑删除")  
//   private String deleteFlag;
   
 }
