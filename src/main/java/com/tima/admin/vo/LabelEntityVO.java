package com.tima.admin.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 标签实体
 * </p>
 *
 * @author YYF
 * @since 2018-12-18
 */
 @Data
 @JsonInclude(JsonInclude.Include.NON_NULL)
 public class LabelEntityVO implements Serializable{ 
    private static final long serialVersionUID = 1L;
   private Long id;
   
   private String no;
   
    @ApiModelProperty(value = "用户标识")  
   private Long uid;

    @ApiModelProperty(value = "用户编码")
    private String  userNo;
   
    @ApiModelProperty(value = "标签ID")  
   private Long labelId;
   
    @ApiModelProperty(value = "描述信息")  
   private String describe;

    @ApiModelProperty(value = "标签名称")
    private String entity;

    @ApiModelProperty(value = "标签属性Id")
    private Long attrId;
   
   private String deleteFlag;
   
   private Long version;
   
    @ApiModelProperty(value = "创建时间")  
   private Date createTime;
   
    @ApiModelProperty(value = "修改时间")  
   private Date updateTime;
   
 }