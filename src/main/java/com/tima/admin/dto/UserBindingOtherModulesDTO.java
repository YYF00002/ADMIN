package com.tima.admin.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * <p>
 * 用户绑定其他模块信息表
 * </p>
 *
 * @author YYF
 * @since 2019-04-09
 */
@Getter
@Setter
 public class UserBindingOtherModulesDTO extends BaseDTO implements Serializable{
   private static final long serialVersionUID = 1L;
   private Long id;
   
    @ApiModelProperty(value = "编码")  
   private String no;
   
    @ApiModelProperty(value = "用户id")
   private Long userId;
   
    @ApiModelProperty(value = "用户默认兴趣事业部id（数组）")
   private String brandsId;

    @ApiModelProperty(value = "用户默认兴趣事业部No（数组）")
    private String brandsNo;
   
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

    @ApiModelProperty(value = "兴趣车型No集合")
    private List<String> brandNos;
   
 }
