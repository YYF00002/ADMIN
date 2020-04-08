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
 * 标签实体
 * </p>
 *
 * @author YYF
 * @since 2018-12-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("label_entity")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LabelEntity extends Model<LabelEntity> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String no;
    /**
     * 用户标识
     */
    private Long uid;
    /**
     * 标签ID
     */
    @TableField("label_id")
    private Long labelId;
    /**
     * 描述信息
     */
    private String describe;
    @TableField("delete_flag")
    @TableLogic
    private String deleteFlag;
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
