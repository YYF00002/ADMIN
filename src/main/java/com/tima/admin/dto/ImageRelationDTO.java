package com.tima.admin.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 * 图片关联表
 * </p>
 *
 * @author zwh
 * @since 2018-07-17
 */
@Getter
@Setter
 public class ImageRelationDTO extends BaseDTO implements Serializable{
   private static final long serialVersionUID = 1L;
   private Long id;
   
    @ApiModelProperty(value = "编码")  
   private String no;
   
    @ApiModelProperty(value = "类型")  
   private String imageType;
   
    @ApiModelProperty(value = "类型下所关联的id")  
   private Long imageTypeId;
   
    @ApiModelProperty(value = "类型下所关联的编码")  
   private String imageTypeNo;
   
    @ApiModelProperty(value = "图片地址")  
   private String imageUrl;
   
    @ApiModelProperty(value = "是否是默认地址")  
   private Integer isDefault;
   
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
