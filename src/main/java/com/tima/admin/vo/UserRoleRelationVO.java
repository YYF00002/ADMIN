package com.tima.admin.vo;

import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import java.util.List;

import lombok.Data;
import java.io.Serializable;

/**
 * <p>
 * 用户角色关联表
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
 @Data
 @JsonInclude(JsonInclude.Include.NON_NULL)
 public class UserRoleRelationVO implements Serializable{ 
    private static final long serialVersionUID = 1L;
   private Long id;
   
    @ApiModelProperty(value = "用户id")  
   private Long userId;
   
    @ApiModelProperty(value = "用户角色id")  
   private Long userRoleId;
   
    @ApiModelProperty(value = "状态")  
   private Integer status;
    
    @ApiModelProperty(value = "用户集合")  
    private List<UserBaseInformationVO> ubis;
    
   
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