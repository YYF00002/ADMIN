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
 * 用户模块积分记录表
 * </p>
 *
 * @author YYF
 * @since 2019-02-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("admin_integral_record")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdminIntegralRecord extends Model<AdminIntegralRecord> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * APP用户id
     */
    private Long uid;
    /**
     * 积分数量
     */
    private String integral;
    /**
     * 变动明细
     */
    @TableField("change_description")
    private String changeDescription;
    /**
     * 活动ID
     */
    @TableField("activity_id")
    private String activityId;
    /**
     * 规则id
     */
    @TableField("rule_id")
    private Integer ruleId;
    /**
     * 积分来源：01：轻卡 02：皮卡 03：重卡 04：乘用车 05：新能源 06：商务车
     */
    @TableField("integral_source")
    private String integralSource;
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
    @TableField("delete_flag")
    @TableLogic
    private Integer deleteFlag;
    @Version
    private Long version;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
