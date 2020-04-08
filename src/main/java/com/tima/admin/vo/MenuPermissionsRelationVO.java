package com.tima.admin.vo;

import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import lombok.Data;
import java.io.Serializable;

/**
 * <p>
 * 菜单权限关联表
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
 @Data
 @JsonInclude(JsonInclude.Include.NON_NULL)
 public class MenuPermissionsRelationVO implements Serializable{ 
    private static final long serialVersionUID = 1L;
   private Long id;
   
    @ApiModelProperty(value = "编码")  
   private String no;
   
    @ApiModelProperty(value = "菜单主键id")  
   private Long menuId;
   
    @ApiModelProperty(value = "权限主键id")  
   private Long permissionsId;
   
    @ApiModelProperty(value = "状态（根据需要使用）")  
   private Integer status;
   
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