package com.tima.admin.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 品牌
 * </p>
 *
 * @author WY
 * @since 2018-07-17
 */
 @Data
 @JsonInclude(JsonInclude.Include.NON_NULL)
 public class VehicleBrandVO implements Serializable{ 
    private static final long serialVersionUID = 1L;
   private Long id;
   
    @ApiModelProperty(value = "品牌编码")  
   private String no;
   
    @ApiModelProperty(value = "品牌名称")  
   private String brandName;

    @ApiModelProperty(value = "制造商name")
    private String makerName;

    @ApiModelProperty(value = "制造商id")  
   private Long makerId;
   
    @ApiModelProperty(value = "制造商编码")  
   private String makerNo;
    
    @ApiModelProperty(value = "排序")
	private Integer sort;
   
//    @ApiModelProperty(value = "创建人")  
//   private String createdBy;
//   
//    @ApiModelProperty(value = "创建时间")  
//   private Date createdDate;
//   
//    @ApiModelProperty(value = "修改人")  
//   private String lastModifiedBy;
//   
	@ApiModelProperty(value = "最后修改时间")
	private Date lastModifiedDate;
//   
//    @ApiModelProperty(value = "版本号")  
//   private Long version;
//   
//    @ApiModelProperty(value = "逻辑删除")  
//   private String deleteFlag;
   
 }