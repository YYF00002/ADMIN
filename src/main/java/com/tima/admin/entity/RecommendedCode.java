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
 * 用户推荐码
 * </p>
 *
 * @author YYF
 * @since 2018-08-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("recommended_code")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecommendedCode extends Model<RecommendedCode> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String no;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 推荐码code
     */
    private String code;
    /**
     * 推荐次数
     */
    @TableField("recommended_time")
    private Integer recommendedTime;
    /**
     * 推荐累计次数
     */
    @TableField("cumulative_time")
    private Integer cumulativeTime;
    /**
     * 推荐码类型
     */
    @TableField("recommended_type")
    private String recommendedType;
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
     * 修改时间
     */
    @TableField("last_modified_date")
    private Date lastModifiedDate;
    /**
     * 版本
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
