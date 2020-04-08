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
 * 标签属性分类
 * </p>
 *
 * @author YYF
 * @since 2018-12-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("label_attribute")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LabelAttribute extends Model<LabelAttribute> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     *
     */
    @TableField("no")
    private String no;
    /**
     * 类型名字
     */
    @TableField("type_name")
    private String typeName;
    /**
     * 类型描述
     */
    private String describe;
    /**
     * 标签效能类型id
     */
    @TableField("effect_id")
    private Integer effectId;
    @TableField("delete_flag")
    @TableLogic
    private Integer deleteFlag;
    @Version
    private Long version;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
