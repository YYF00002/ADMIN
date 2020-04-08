package com.tima.admin.vo;

import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tima.admin.util.TreeExtend;
import com.tima.admin.util.TreeField;
import com.tima.admin.util.TreeProperty;

import java.util.Date;
import lombok.Data;
import java.io.Serializable;

/**
 * <p>
 * 用户菜单信息表
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
 @Data
 @JsonInclude(JsonInclude.Include.NON_NULL)
 public class UserMenuInfoVO  implements Serializable { 
    private static final long serialVersionUID = 1L;
   private Long id;
   
    @ApiModelProperty(value = "编码")  
   private String no;
   
    @ApiModelProperty(value = "菜单编码（根据需要使用）")  
   private String menuCode;
   
    @ApiModelProperty(value = "菜单名称")  
   private String menuName;
   
    @ApiModelProperty(value = "菜单类型 0为后台系统菜单 1为前台业务菜单")  
   private Integer menuType;
   
    @ApiModelProperty(value = "上级菜单id") 
   private Long menuParentId;
   
    @ApiModelProperty(value = "内部序号供排序使用")  
   private String orderNum;
   
    @ApiModelProperty(value = "菜单url地址")  
   private String menuUrl;
   
    @ApiModelProperty(value = "是否末级 Y为末级 N或者空为非末级 默认为N(根据需要使用)")  
   private String isEnd;
    
    @ApiModelProperty(value = "是否是菜单：0：不是：1：是")  
   private Integer isMenu;
   
    @ApiModelProperty(value = "菜单级别")  
   private Integer menuLevel;
   
    @ApiModelProperty(value = "菜单图标")  
   private String menuIco;
   
    @ApiModelProperty(value = "备用字段1")  
   private String attribute1;
   
    @ApiModelProperty(value = "备用字段2")  
   private String attribute2;
   
    @ApiModelProperty(value = "备用字段3")  
   private String attribute3;
   
    @ApiModelProperty(value = "备用字段4")  
   private String attribute4;
   
    @ApiModelProperty(value = "备用字段5")  
   private String attribute5;
   
    @ApiModelProperty(value = "备用字段6")  
   private String attribute6;
   
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