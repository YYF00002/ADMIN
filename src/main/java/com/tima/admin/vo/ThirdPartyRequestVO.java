package com.tima.admin.vo;

import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tima.admin.dto.AAADTO;

import java.util.Date;
import lombok.Data;
import java.io.Serializable;

/**
 * <p>
 * 第三方请求记录表
 * </p>
 *
 * @author YYF
 * @since 2018-08-14
 */
 @Data
 @JsonInclude(JsonInclude.Include.NON_NULL)
 public class ThirdPartyRequestVO implements Serializable{ 
    private static final long serialVersionUID = 1L;
   private Long id;
   
   private String no;
   
    @ApiModelProperty(value = "请求来源：1.DMS 2.AAA 3.TSP")  
   private Integer requestSource;
   
    @ApiModelProperty(value = "请求方法")  
   private String requestMethod;
   
    @ApiModelProperty(value = "请求参数")  
   private String requestJson;
   
    @ApiModelProperty(value = "响应参数")  
   private String responseJson;
    
	@ApiModelProperty(value = "token")
	private String token;
	
	@ApiModelProperty(value = "授权码")
	private String authorization;
	
	@ApiModelProperty(value = "错误描述")
	private String errorDescription;
	
	@ApiModelProperty(value = "错误码")
	private Integer errorCode;
	
	// AAA属性
	@ApiModelProperty(value = "AAA属性dto")
	private AAADTO AAAdto;
   
//    @ApiModelProperty(value = "创建人")  
//   private String createdBy;
//   
//    @ApiModelProperty(value = "创建时间")  
//   private Date createdDate;
//   
//    @ApiModelProperty(value = "修改人")  
//   private String lastModifiedBy;
//   
//    @ApiModelProperty(value = "最后修改时间")  
//   private Date lastModifiedDate;
//   
//    @ApiModelProperty(value = "版本号")  
//   private Long version;
//   
//    @ApiModelProperty(value = "逻辑删除")  
//   private String deleteFlag;
   
 }