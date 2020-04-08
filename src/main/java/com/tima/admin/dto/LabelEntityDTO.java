package com.tima.admin.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * <p>
 * 标签实体
 * </p>
 *
 * @author YYF
 * @since 2018-12-18
 */
@Getter
@Setter
 public class LabelEntityDTO extends BaseDTO implements Serializable{
   private static final long serialVersionUID = 1L;
   private Long id;
   
   private String no;
   
    @ApiModelProperty(value = "用户标识")  
   private Long uid;

    @ApiModelProperty(value = "用户编码集合")
    private List<String> userNos;

    @ApiModelProperty(value = "用户编码")
    private String userNo;
   
    @ApiModelProperty(value = "标签ID")  
   private Long labelId;

    @ApiModelProperty(value = "标签no")
    private String labelNo;

    @ApiModelProperty(value = "标签名称")
    private String level;
   
    @ApiModelProperty(value = "描述信息")  
   private String describe;
   
   private String deleteFlag;
   
   private Long version;
   
    @ApiModelProperty(value = "创建时间")  
   private Date createTime;
   
    @ApiModelProperty(value = "修改时间")  
   private Date updateTime;


    @ApiModelProperty(value = "是否是车主  0 车主   1非车主")
    private Integer isOwner;

    @ApiModelProperty(value = "积分传过来的标签id")
    private Long levelId;
 }
