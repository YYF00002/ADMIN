package com.tima.admin.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.DecimalMin;

import com.tima.admin.validateInterface.ISelect;
import com.tima.admin.validateInterface.ISelectWeb;


/**
 * <p>
 * 国统局区域代码
 * </p>
 *
 * @author YYF
 * @since 2018-08-01
 */
@Getter
@Setter
 public class CountryAreaCodeDTO extends BaseDTO implements Serializable{
   private static final long serialVersionUID = 1L;
   private Long id;
   
    @ApiModelProperty(value = "区域代码")  
   private String code;
   
    @ApiModelProperty(value = "区域名称")  
   private String name;
   
    @ApiModelProperty(value = "父级id")  
   private Long parentId;
   
    @ApiModelProperty(value = "上级区域代码")  
   private String parentCode;
   
    @ApiModelProperty(value = "层级")  
    @DecimalMin(value="1",groups= {ISelect.class,ISelectWeb.class})
   private Integer level;
   
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
