package com.tima.admin.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.Version;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * <p>
 * 用户角色关联表
 * </p>
 *
 * @author YYF
 * @since 2018-07-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user_role_relation")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRoleRelation extends Model<UserRoleRelation> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 用户角色id
     */
    @TableField("user_role_id")
    private Long userRoleId;
    /**
     * 状态
     */
    private Integer status;
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
