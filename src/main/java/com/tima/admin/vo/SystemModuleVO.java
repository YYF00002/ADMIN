package com.tima.admin.vo;

import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import lombok.Data;
import java.io.Serializable;

/**
 * <p>
 * 系统模块表
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
 @Data
 @JsonInclude(JsonInclude.Include.NON_NULL)
 public class SystemModuleVO implements Serializable{ 
    private static final long serialVersionUID = 1L;
   private Long id;
   
    @ApiModelProperty(value = "编码")  
   private String no;
   
    @ApiModelProperty(value = "模块名称")  
   private String moduleName;
   
    @ApiModelProperty(value = "状态（根据需要使用）")  
   private Integer status;
   
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