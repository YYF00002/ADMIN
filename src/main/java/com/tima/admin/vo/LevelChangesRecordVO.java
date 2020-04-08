package com.tima.admin.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 会员等级变动明细表
 * </p>
 *
 * @author YYF
 * @since 2019-05-05
 */
 @Data
 @JsonInclude(JsonInclude.Include.NON_NULL)
 public class LevelChangesRecordVO implements Serializable{ 
    private static final long serialVersionUID = 1L;
   private Long id;
   
   private String no;
   
    @ApiModelProperty(value = "用户标识")  
   private Long uid;
   
    @ApiModelProperty(value = "原等级ID")  
   private Long labelIdOld;
   
    @ApiModelProperty(value = "新等级ID")  
   private Long labelIdNew;

    @ApiModelProperty(value = "原等级名称")
    private String labelOldName;

    @ApiModelProperty(value = "新等级名称")
    private String labelNewName;

    @ApiModelProperty(value = "是否推送（0 未推送 1 已推送）")  
   private String isPush;
   
    @ApiModelProperty(value = "描述信息")  
   private String describe;
   
   private String deleteFlag;
   
   private Long version;
   
    @ApiModelProperty(value = "创建时间")  
   private Date createTime;
   
    @ApiModelProperty(value = "修改时间")  
   private Date updateTime;
   
 }