package com.tima.admin.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 * 标签效能状态分类分类
 * </p>
 *
 * @author YYF
 * @since 2018-12-10
 */
@Getter
@Setter
 public class LabelEffectDTO extends BaseDTO implements Serializable{
   private static final long serialVersionUID = 1L;
   private Long id;
   
    @ApiModelProperty(value = "类型名字")  
   private String typeName;
   
    @ApiModelProperty(value = "类型描述")  
   private String describe;
   
   private Integer deleteFlag;
   
   private Long version;
   
    @ApiModelProperty(value = "创建时间")  
   private Date createTime;
   
    @ApiModelProperty(value = "修改时间")  
   private Date updateTime;
   
 }
