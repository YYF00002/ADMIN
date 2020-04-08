package com.tima.admin.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * <p>
 * 会员等级变动明细表
 * </p>
 *
 * @author YYF
 * @since 2019-05-05
 */
@Getter
@Setter
 public class LevelChangesRecordDTO extends BaseDTO implements Serializable{
   private static final long serialVersionUID = 1L;
   private Long id;
   
   private String no;
   
    @ApiModelProperty(value = "用户标识")  
   private Long uid;
   
    @ApiModelProperty(value = "原等级ID")  
   private Long labelIdOld;
   
    @ApiModelProperty(value = "新等级ID")  
   private Long labelIdNew;
   
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


    @ApiModelProperty(value = "标识集合")
    private List<String> nos;
 }
