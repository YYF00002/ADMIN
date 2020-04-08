package com.tima.admin.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 第三方登录信息表 
 * </p>
 *
 * @author YYF
 * @since 2020-03-23
 */
 @Data
 @JsonInclude(JsonInclude.Include.NON_NULL)
 public class ThirdPartyUserLoginVO implements Serializable{ 
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = " id")  
   private Long id;
   
    @ApiModelProperty(value = "编码")  
   private String no;
   
    @ApiModelProperty(value = "用户id")  
   private Long userId;
   
    @ApiModelProperty(value = "第三方标识")  
   private String openId;
   
    @ApiModelProperty(value = "第三方token")  
   private String token;
   
    @ApiModelProperty(value = "第三方类型 0.微信 1.QQ")  
   private String type;
   
    @ApiModelProperty(value = "第三方头像")  
   private String headImg;
   
    @ApiModelProperty(value = "昵称")  
   private String nick;
   
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