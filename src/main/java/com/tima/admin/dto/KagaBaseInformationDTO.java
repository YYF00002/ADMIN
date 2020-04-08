package com.tima.admin.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 * 卡嘉用户表
 * </p>
 *
 * @author YYF
 * @since 2019-12-26
 */
@Getter
@Setter
 public class KagaBaseInformationDTO extends BaseDTO implements Serializable{
   private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = " id")  
   private Long id;
   
    @ApiModelProperty(value = "请求标识符")  
   private Long requestId;
   
    @ApiModelProperty(value = "车联网标识符")  
   private String aaaId;
   
    @ApiModelProperty(value = "卡嘉账户名")  
   private String userName;
   
    @ApiModelProperty(value = "卡嘉账户类型")  
   private String type;
   
    @ApiModelProperty(value = "用户密码")  
   private String password;
   
    @ApiModelProperty(value = "备用")  
   private String tableBk;
   
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

    @ApiModelProperty(value = "手机号")
    private String phone;
}
