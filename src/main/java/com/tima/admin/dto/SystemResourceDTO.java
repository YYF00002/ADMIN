package com.tima.admin.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 * 系统资源表
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
@Getter
@Setter
 public class SystemResourceDTO extends BaseDTO implements Serializable{
   private static final long serialVersionUID = 1L;
   private Long id;
   
    @ApiModelProperty(value = "编码")  
   private String no;
   
    @ApiModelProperty(value = "模块id")  
   private Long moduleId;
   
    @ApiModelProperty(value = "模块编码")  
   private String moduleNo;
   
    @ApiModelProperty(value = "模块名称")  
   private String moduleName;
   
    @ApiModelProperty(value = "服务名称")  
   private String serivceName;
   
    @ApiModelProperty(value = "接口名称")  
   private String apiName;
   
    @ApiModelProperty(value = "方法名称")  
   private String methodName;
   
    @ApiModelProperty(value = "模块路径")  
   private String modulePath;
   
    @ApiModelProperty(value = "方法路径")  
   private String methodPath;
   
    @ApiModelProperty(value = "接口地址")  
   private String url;
   
    @ApiModelProperty(value = "备注")  
   private String remark;
   
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
