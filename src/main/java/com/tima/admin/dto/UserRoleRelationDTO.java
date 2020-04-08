package com.tima.admin.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 * 用户角色关联表
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
@Getter
@Setter
 public class UserRoleRelationDTO extends BaseDTO implements Serializable{
   private static final long serialVersionUID = 1L;
   private Long id;
   
    @ApiModelProperty(value = "用户id")  
   private Long userId;
   
    @ApiModelProperty(value = "用户no")  
    private String userNo;
    
    @ApiModelProperty(value = "用户角色id")  
   private Long userRoleId;
   
    @ApiModelProperty(value = "用户角色no")  
    private String userRoleNo;
    
    @ApiModelProperty(value = "状态")  
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
