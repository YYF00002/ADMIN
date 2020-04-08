package com.tima.admin.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 标签信息
 * </p>
 *
 * @author YYF
 * @since 2018-12-18
 */
 @Data
 @JsonInclude(JsonInclude.Include.NON_NULL)
 public class LabelInfoVO implements Serializable{ 
    private static final long serialVersionUID = 1L;
   private Long id;
   
   private String no;
   
    @ApiModelProperty(value = "标签属性分类")  
   private Long attrId;
   
    @ApiModelProperty(value = "标签名称")  
   private String labelName;
   
    @ApiModelProperty(value = "0.自动标签  1.手动标签")  
   private String type;
   
    @ApiModelProperty(value = "标签描述")  
   private String describe;
   
    @ApiModelProperty(value = "状态 0.启用  1.禁用")  
   private String status;
   
    @ApiModelProperty(value = "是否展示 0.展示  1.不展示")  
   private String isShow;
   
   private String deleteFlag;
   
   private Long version;
   
    @ApiModelProperty(value = "创建时间")  
   private Date createTime;
   
    @ApiModelProperty(value = "修改时间")  
   private Date updateTime;
   
 }