package com.tima.admin.vo;

import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import lombok.Data;
import java.io.Serializable;

/**
 * <p>
 * 用户收货地址
 * </p>
 *
 * @author YYF
 * @since 2018-07-17
 */
 @Data
 @JsonInclude(JsonInclude.Include.NON_NULL)
 public class UserAddressVO implements Serializable{ 
    private static final long serialVersionUID = 1L;
   private Long id;
   
    @ApiModelProperty(value = "编码")  
   private String no;
   
    @ApiModelProperty(value = "用户id")  
   private Long userId;
   
    @ApiModelProperty(value = "用户编码")  
   private String userNo;
   
    @ApiModelProperty(value = "收货人姓名")  
   private String receiveName;
   
    @ApiModelProperty(value = "收货人联系电话")  
   private String receiveMobile;
   
    @ApiModelProperty(value = "是否默认地址")  
   private Integer isDefault;
   
    @ApiModelProperty(value = "收货人地址")  
   private String address;
   
    @ApiModelProperty(value = "邮编")  
   private String zipcode;
   
    @ApiModelProperty(value = "省份id")  
   private Long provinceId;
   
    @ApiModelProperty(value = "省份编码")  
   private String provinceCode;
   
    @ApiModelProperty(value = "省份名称")  
   private String provinceName;
   
    @ApiModelProperty(value = "城市id")  
   private Long cityId;
   
    @ApiModelProperty(value = "城市编码")  
   private String cityCode;
   
    @ApiModelProperty(value = "城市名称")  
   private String cityName;
   
    @ApiModelProperty(value = "区域id")  
   private Long countryId;
   
    @ApiModelProperty(value = "区域编码")  
   private String countryCode;
   
    @ApiModelProperty(value = "区域名称")  
   private String countryName;
   
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