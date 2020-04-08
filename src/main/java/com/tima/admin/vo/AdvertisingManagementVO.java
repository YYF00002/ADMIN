package com.tima.admin.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 广告页管理
 * </p>
 *
 * @author YYF
 * @since 2020-02-18
 */
 @Data
 @JsonInclude(JsonInclude.Include.NON_NULL)
 public class AdvertisingManagementVO implements Serializable{ 
    private static final long serialVersionUID = 1L;
   private Long id;
   
    @ApiModelProperty(value = "编码")  
   private String no;
   
    @ApiModelProperty(value = "标题")  
   private String title;
   
    @ApiModelProperty(value = "图片地址")  
   private String url;
   
    @ApiModelProperty(value = "状态 0.为启用 1.启动")  
   private String status;
   
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