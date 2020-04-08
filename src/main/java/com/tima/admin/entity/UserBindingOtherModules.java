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
 * 用户绑定其他模块信息表
 * </p>
 *
 * @author YYF
 * @since 2019-04-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user_binding_other_modules")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserBindingOtherModules extends Model<UserBindingOtherModules> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 编码
     */
    private String no;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 用户默认兴趣事业部（数组）
     */
    @TableField("brands_id")
    private String brandsId;
    /**
     * 用户默认兴趣事业部（数组）
     */
    @TableField("brands_no")
    private String brandsNo;
    /**
     * 备用字段1
     */
    private String attribute1;
    /**
     * 备用字段2
     */
    private String attribute2;
    /**
     * 备用字段3
     */
    private String attribute3;
    /**
     * 备用字段4
     */
    private String attribute4;
    /**
     * 备用字段5
     */
    private String attribute5;
    /**
     * 备用字段6
     */
    private String attribute6;
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
