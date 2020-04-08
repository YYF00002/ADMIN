package com.tima.admin.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 系统字典类型表
 * </p>
 *
 * @author YYF
 * @since 2018-11-20
 */
 @Data
 @JsonInclude(JsonInclude.Include.NON_NULL)
 public class SysDictTypeVO implements Serializable{ 
    private static final long serialVersionUID = 1L;
   private Long id;
   
    @ApiModelProperty(value = "字典名称")  
   private String dictName;
   
    @ApiModelProperty(value = "字典类型")  
   private String dictType;
   
    @ApiModelProperty(value = "状态（0正常 1停用）")  
   private String status;
   
    @ApiModelProperty(value = "是否显示（0显示 1不显示）")  
   private String isDisplay;
   
    @ApiModelProperty(value = "备注")  
   private String remark;

    @ApiModelProperty(value = "字典数据集合")
    private List<SysDictDataVO> SysDictDataVOs;

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