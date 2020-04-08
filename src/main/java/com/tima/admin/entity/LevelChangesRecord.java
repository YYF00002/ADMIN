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
 * 会员等级变动明细表
 * </p>
 *
 * @author YYF
 * @since 2019-05-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("level_changes_record")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LevelChangesRecord extends Model<LevelChangesRecord> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String no;
    /**
     * 用户标识
     */
    private Long uid;
    /**
     * 原等级ID
     */
    @TableField("label_id_old")
    private Long labelIdOld;
    /**
     * 新等级ID
     */
    @TableField("label_id_new")
    private Long labelIdNew;
    /**
     * 是否推送（0 未推送 1 已推送）
     */
    @TableField("is_push")
    private String isPush;
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
