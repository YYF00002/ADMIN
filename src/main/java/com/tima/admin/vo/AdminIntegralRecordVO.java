package com.tima.admin.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户模块积分记录表
 * </p>
 *
 * @author YYF
 * @since 2019-02-21
 */
 @Data
 @JsonInclude(JsonInclude.Include.NON_NULL)
 public class AdminIntegralRecordVO implements Serializable{ 
    private static final long serialVersionUID = 1L;
   private Integer id;
   
    @ApiModelProperty(value = "APP用户id")  
   private Long uid;
   
    @ApiModelProperty(value = "积分数量")  
   private String integral;
   
    @ApiModelProperty(value = "变动明细")  
   private String changeDescription;
   
    @ApiModelProperty(value = "活动ID")  
   private String activityId;
   
    @ApiModelProperty(value = "规则id")  
   private Integer ruleId;
   
    @ApiModelProperty(value = "积分来源：01：轻卡 02：皮卡 03：重卡 04：乘用车 05：新能源 06：商务车")  
   private String integralSource;
   
    @ApiModelProperty(value = "创建人")  
   private String createdBy;
   
    @ApiModelProperty(value = "创建时间")  
   private Date createdDate;
   
    @ApiModelProperty(value = "修改人")  
   private String lastModifiedBy;
   
    @ApiModelProperty(value = "最后修改时间")  
   private Date lastModifiedDate;
   
   private Integer deleteFlag;
   
   private Long version;
   
 }