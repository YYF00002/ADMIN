package com.tima.admin.dto;


import com.tima.admin.validateInterface.ISelect;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 * 设备版本记录表
 * </p>
 *
 * @author YYF
 * @since 2018-11-28
 */
@Getter
@Setter
 public class DeviceVersionRecordDTO extends BaseDTO implements Serializable{
   private static final long serialVersionUID = 1L;
   private Long id;
   
    @ApiModelProperty(value = "编码")  
   private String no;
   
    @ApiModelProperty(value = "设备名称")
    @NotBlank(groups = {ISelect.class})
   private String deviceName;
   
    @ApiModelProperty(value = "版本号ID")
   private Long versionId;

    @ApiModelProperty(value = "版本号")
    @NotBlank(groups = {ISelect.class})
    private String versionNumber;
   
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
