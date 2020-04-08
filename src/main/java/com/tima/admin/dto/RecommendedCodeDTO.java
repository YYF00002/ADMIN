package com.tima.admin.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 * 用户推荐码
 * </p>
 *
 * @author YYF
 * @since 2018-08-29
 */
@Getter
@Setter
 public class RecommendedCodeDTO extends BaseDTO implements Serializable{
   private static final long serialVersionUID = 1L;
   private Long id;
   
   private String no;
   
    @ApiModelProperty(value = "用户id")  
   private Long userId;
    
    @ApiModelProperty(value = "用户No")  
    private String userNo;
   
    @ApiModelProperty(value = "推荐码code")  
   private String code;

    @ApiModelProperty(value = "推荐码累计成功次数")
    private String cumulativeTime;


    @ApiModelProperty(value = "推荐次数")  
   private Integer recommendedTime;
   
    @ApiModelProperty(value = "推荐码类型")  
   private String recommendedType;
   
    @ApiModelProperty(value = "创建人")  
   private String createdBy;
   
    @ApiModelProperty(value = "创建时间")  
   private Date createdDate;
   
    @ApiModelProperty(value = "修改人")  
   private String lastModifiedBy;
   
    @ApiModelProperty(value = "修改时间")  
   private Date lastModifiedDate;
   
    @ApiModelProperty(value = "版本")  
   private Long version;
   
    @ApiModelProperty(value = "逻辑删除")  
   private String deleteFlag;
   
 }
