package com.tima.admin.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.*;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 字典数据表
 * </p>
 *
 * @author YYF
 * @since 2018-11-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_dict_data")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysDictData extends Model<SysDictData> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 字典编码
     */
    @TableField("dict_code")
    private String dictCode;
    /**
     * 排序
     */
    @TableField("dict_sort")
    private Integer dictSort;
    /**
     * 字典类型
     */
    @TableField("dict_type")
    private String dictType;
    /**
     * 字典值
     */
    @TableField("dict_value")
    private String dictValue;
    /**
     * 是否默认（Y是 N否）
     */
    @TableField("is_default")
    private String isDefault;
    /**
     * 字典编码父节点
     */
    @TableField("dict_parent_code")
    private String dictParentCode;
    /**
     * 父节点id
     */
    @TableField("parent_id")
    private Long parentId;
    /**
     * 状态（0正常 1停用）
     */
    private String status;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建人
     */
    @TableField("created_by")
    private String createdBy;
    /**
     * 创建时间
     */
    @TableField("created_date")
    private Date createdDate;
    /**
     * 修改人
     */
    @TableField("last_modified_by")
    private String lastModifiedBy;
    /**
     * 最后修改时间
     */
    @TableField("last_modified_date")
    private Date lastModifiedDate;
    /**
     * 版本号
     */
    @Version
    private Long version;
    /**
     * 逻辑删除
     */
    @TableField("delete_flag")
    @TableLogic
    private String deleteFlag;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
